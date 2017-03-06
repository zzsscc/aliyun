/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: KeywordTask
 * Creator:  wanggao
 * Create-Date: 上午9:55
 **/
package com.eshutech.biz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshutech.biz.constant.Constants;
import com.eshutech.biz.entity.TblDatavKeywords;
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
 * @date: 16/11/2
 * @time: 上午9:55
 *
 */
@TaskThread(
        model = "Keyword",
        initialDelay = 10,
        delay = 2
)
public class KeywordTask extends BaseTaskThread{

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    private static final Logger logger = LoggerFactory.getLogger(KeywordTask.class);

    private static final BlockingQueue<TblDatavKeywords> matchQueue = new LinkedBlockingQueue();

    public KeywordTask() {
    }

    public static void BI(TblDatavKeywords tblDatavKeywords) {
        try {
            if(null != tblDatavKeywords.getKeywordId())
            {
                return;
            }
            if(!matchQueue.contains(tblDatavKeywords))
            {
                matchQueue.put(tblDatavKeywords);
            }
        } catch (InterruptedException var10) {
            var10.printStackTrace();
        }
    }

    public void runFunction() {
        try {
            int ex = matchQueue.size();
            logger.debug("--------[KeywordTask] RUN:{}--------", ex);
            int maxCount = LocalConfig.I().GI("KeyowrdTask_Max", 1);
            List<TblDatavKeywords> keywordList = Lists.newArrayList();
            if(ex > maxCount) {
                matchQueue.drainTo(keywordList, maxCount);
            } else {
                matchQueue.drainTo(keywordList, ex);
            }

            if(keywordList.size() > 0) {
                //单个插入
                StringBuilder msg = new StringBuilder();
                int successCount = 0;
                msg.append("向阿里云添加").append(keywordList.size()).append("个关键字,");
                for(TblDatavKeywords record:keywordList)
                {
                    //请求接口
                    TblDatavTopics tblDatavTopics = tblDatavTopicsMapper.selectByPrimaryKey(record.getTopicId());
                    List<Integer> typeList = JSON.parseArray(record.getSiteTypeIds(),Integer.class);
                    //单个关键词
                    Map<String,Object> param = new HashMap<String, Object>();
                    param.put("topicId",Integer.parseInt(tblDatavTopics.getTopicId()));
                    param.put("keywords", record.getKeyword());
                    param.put("siteTypeIds",typeList);
                    String paramBody = JSON.toJSONString(param);
                    String result = AESDecode.sendPost(Constants.URL+"createKeyword",paramBody, Constants.AK_ID, Constants.AK_SECRET);
                    logger.info(result);
                    JSONObject object = JSON.parseObject(result);
                    if(object.getBoolean("success")) {
                        Integer keywordId = object.getInteger("result");
                        record.setKeywordId(keywordId);
                        record.setModifyTime(new Date());
                        tblDatavKeywordsMapper.updateByPrimaryKey(record);
                        successCount ++;
                    }
                }
                msg.append("成功").append(successCount).append("条");
                logger.info(msg.toString());
            }
        } catch (Exception var5) {
//            logger.error("--------[KeywordTask] Exception:{}--------", ExceptionUtils.getStackTrace(var5));
        }

    }
}
