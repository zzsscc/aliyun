/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SentimentTask
 * Creator:  wanggao
 * Create-Date: 上午10:02
 **/
package com.eshutech.biz.task;

import com.eshutech.biz.cache.rediscache.IRedisCacheService;
import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.service.SearchService;
import com.eshutech.biz.service.SystemCodeService;
import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import com.google.common.collect.Lists;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Kim
 * @date: 16/11/4
 * @time: 上午10:02
 */
@TaskThread(
        model = "SentimentTask",
        initialDelay = 10,
        delay = 2
)
public class SentimentTask extends BaseTaskThread {
    @Resource
    IRedisCacheService redisCacheService;

    @Resource
    SearchService searchService;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    SystemCodeService systemCodeService;

    private static final Logger logger = LoggerFactory.getLogger(SentimentTask.class);


    private static final BlockingQueue<TblSearchRecord> matchQueue = new LinkedBlockingQueue();

    public SentimentTask() {
    }

    public static void BI(List<TblSearchRecord> recordList,String instanceId) {
        try {
            for (TblSearchRecord searchRecord : recordList) {
                searchRecord.setInstanceId(instanceId);
                matchQueue.put(searchRecord);
            }
        } catch (InterruptedException var10) {
            var10.printStackTrace();
        }
    }

    public void runFunction() {
        try {
            int ex = matchQueue.size();
            logger.debug("--------[SentimentTask] RUN:{}--------", ex);
            int maxCount = LocalConfig.I().GI("SentimentTask_Max", 1000);
            List<TblSearchRecord> sentimentJobs = Lists.newArrayList();
            if (ex > maxCount) {
                matchQueue.drainTo(sentimentJobs, maxCount);
            } else {
                matchQueue.drainTo(sentimentJobs, ex);
            }

            Map<String,String> instanceMap = new HashMap<String, String>();

            if (sentimentJobs.size() > 0) {
                logger.info("开始更新缓存");
                StringBuilder msg = new StringBuilder();
                int totalCount = sentimentJobs.size();
                int successCount = 0;
                msg.append("批量插入").append(totalCount).append("条记录,");
                for (TblSearchRecord record : sentimentJobs) {
                    try {
                        //更新舆情
                        instanceMap.put(record.getInstanceId(),"");
                        redisCacheService.addSentiment(record.getInstanceId(), record);
                        successCount++;
                        //更新热门
                    } catch (Exception e) {

                    }
                }
                Set<String> keys = instanceMap.keySet();

                Long cacheLimit = Long.parseLong(systemCodeService.getSystemCodeValue("cache_limit"));
                if(cacheLimit.equals(0L))
                {
                    cacheLimit = 500L;
                }

                for(String key :keys){
                    redisCacheService.ltrimSentiment(key, cacheLimit);
                }

                msg.append("成功").append(successCount).append("条");
                logger.info(msg.toString());
                logger.info("更新缓存结束");
            }


        } catch (Exception var5) {
            logger.info("更新缓存异常:" + ExceptionUtils.getStackTrace(var5));
        }

    }
}
