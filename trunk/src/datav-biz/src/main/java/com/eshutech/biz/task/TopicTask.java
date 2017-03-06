/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: TopicTask
 * Creator:  wanggao
 * Create-Date: 上午11:38
 **/
package com.eshutech.biz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.util.AESDecode;
import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author: Kim
 * @date: 16/11/14
 * @time: 上午11:38
 *
 */
@TaskThread(
        model = "TopicTask",
        initialDelay = 10,
        delay = 10
)
public class TopicTask extends BaseTaskThread{

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    private static final Logger logger = LoggerFactory.getLogger(KeywordTask.class);

    private static final BlockingQueue<TblDatavTopics> matchQueue = new LinkedBlockingQueue();

    public TopicTask() {
    }

    public static void BI(TblDatavTopics tblDatavTopics) {
        try {
            if(!matchQueue.contains(tblDatavTopics))
            {
                matchQueue.put(tblDatavTopics);
            }
        } catch (InterruptedException var10) {
            var10.printStackTrace();
        }
    }

    public void runFunction() {
        try {
            int ex = matchQueue.size();
            logger.debug("--------[TopicTask] RUN:{}--------", ex);
            int maxCount = LocalConfig.I().GI("TopicTask_Max", 8);
            List<TblDatavTopics> topicsList = Lists.newArrayList();
            if(ex > maxCount) {
                matchQueue.drainTo(topicsList, maxCount);
            } else {
                matchQueue.drainTo(topicsList, ex);
            }

            if(topicsList.size() > 0) {
                //单个更新
                StringBuilder msg = new StringBuilder();
                int successCount = 0;
                for(TblDatavTopics record:topicsList)
                {
                    Map<String,Object> param = new HashMap<String, Object>();
                    //请求更新专题状态
                    param.put("id",Integer.parseInt(record.getTopicId()));
                    param.put("status",record.getTopicStatus());

                    String paramBody = JSON.toJSONString(param);
                    String result = AESDecode.sendPost(Constants.URL+"turnTopic",paramBody, Constants.AK_ID, Constants.AK_SECRET);
                    logger.info(result);
                    JSONObject object = JSON.parseObject(result);
                    if(object.getBoolean("success"))
                    {
                        record.setModifyTime(new Date());
                        tblDatavTopicsMapper.updateByPrimaryKey(record);
                    }
                }
                msg.append("成功").append(successCount).append("条");
                logger.info(msg.toString());
            }
        } catch (Exception var5) {
//            logger.error("--------[TopicTask] Exception:{}--------", ExceptionUtils.getStackTrace(var5));
        }

    }
}
