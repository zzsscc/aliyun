/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SearchJob
 * Creator:  wanggao
 * Create-Date: 上午11:26
 **/
package com.eshutech.biz.task;

import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.entity.TblDatavKeywordsExample;
import com.eshutech.biz.entity.TblDatavTopics;
import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblSearchRecordMapper;
import com.eshutech.biz.service.InstanceProfileService;
import com.eshutech.biz.service.SearchService;
import com.eshutech.biz.util.annotation.TaskThread;
import com.eshutech.biz.util.helper.LocalConfig;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author: Kim
 * @date: 16/10/31
 * @time: 上午11:26
 *
 */
@TaskThread(
        model = "SearchTask",
        initialDelay = 10,
        delay = 10
)
public class SearchTask extends BaseTaskThread{

    @Resource
    SearchService searchService;

    @Resource
    TblSearchRecordMapper tblSearchRecordMapper;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    InstanceProfileService instanceProfileService;


    private static final Logger logger = LoggerFactory.getLogger(SearchTask.class);

    private static final BlockingQueue<TblSearchRecord> matchQueue = new LinkedBlockingQueue();

    public SearchTask() {
    }

    public static void BI(TblSearchRecord tblSearchRecord) {
        try {
            matchQueue.put(tblSearchRecord);
        } catch (InterruptedException var10) {
            var10.printStackTrace();
        }
    }

    public void runFunction() {
        try {
            int ex = matchQueue.size();
            logger.debug("--------[SearchTask] RUN:{}--------", ex);
            int maxCount = LocalConfig.I().GI("SearchJob_Max", 10000);
            List<TblSearchRecord> searchJobs = Lists.newArrayList();
            if(ex > maxCount) {
                matchQueue.drainTo(searchJobs, maxCount);
            } else {
                matchQueue.drainTo(searchJobs, ex);
            }

            if(searchJobs.size() > 0) {
                //单个插入
                StringBuilder msg = new StringBuilder();
                int successCount = 0;
                msg.append("批量插入").append(searchJobs.size()).append("条记录,");
                for(TblSearchRecord record:searchJobs)
                {
                    try {
                        int insertResult = tblSearchRecordMapper.insert(record);
                        if (insertResult != 0) {
                            successCount++;
                            TblDatavKeywordsExample example = new TblDatavKeywordsExample();
                            example.createCriteria().andKeywordEqualTo(record.getMonitorKeywords());

                            List<TblDatavKeywords> keywordsList = tblDatavKeywordsMapper.selectByExample(example);
                            for(TblDatavKeywords keywords:keywordsList)
                            {
                                TblDatavTopics topics = tblDatavTopicsMapper.selectByPrimaryKey(keywords.getTopicId());
                                instanceProfileService.addSentimentCount(topics.getInstanceId(),1);
                            }
                        }


                    }
                    catch (Exception e)
                    {
//                        logger.error("--------[SearchTask-Insert] Exception:{}--------", ExceptionUtils.getStackTrace(e));
                    }
                }
                msg.append("成功").append(successCount).append("条");
                logger.info(msg.toString());
            }
        } catch (Exception var5) {
//            logger.error("--------[SearchTask] Exception:{}--------", ExceptionUtils.getStackTrace(var5));
        }

    }
}
