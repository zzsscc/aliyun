/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SentimentJob
 * Creator:  wanggao
 * Create-Date: 上午9:55
 **/
package com.eshutech.job;

import com.eshutech.biz.cache.rediscache.IRedisCacheService;
import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.entity.TblSearchRecordExample;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblSearchRecordMapper;
import com.eshutech.biz.service.DatavKeywordsService;
import com.eshutech.biz.service.DatavTopicsService;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.service.SystemCodeService;
import com.eshutech.biz.task.SentimentTask;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Kim
 * @date: 16/11/4
 * @time: 上午9:55
 */
@Component
public class SentimentJob {
    private static final Logger logger = LoggerFactory.getLogger(SentimentJob.class);
    @Resource
    SystemCodeService systemCodeService;

    @Resource
    TblSearchRecordMapper tblSearchRecordMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    IsvInstanceService isvInstanceService;

    @Resource
    DatavTopicsService datavTopicsService;

    @Resource
    DatavKeywordsService datavKeywordsService;

    @Resource
    IRedisCacheService redisCacheService;

    private static boolean isRun = false;


//    @Scheduled(cron = "0 0/15 * * * ?")
    public void sentimentJob() throws UnsupportedEncodingException {
        String status = systemCodeService.getSystemCodeValue("sentimentJobStatus");
        if (status.equals("0")) {
            return;
        }
        String lastUpdateId = systemCodeService.getSystemCodeValue("sentiment_last_update_id");
        if(!lastUpdateId.equals("-1"))
        {
            return;
        }
        String currentUid = tblDatavTopicsMapper.selectNextInstanceId(lastUpdateId);
        systemCodeService.updateSystemCode("sentiment_last_update_id", currentUid);
        logger.info("启动更新舆情任务,第一个id为:" + currentUid);
    }


//    @Scheduled(cron = "0/2 * * * * ?")
    public void sentimentSync() throws UnsupportedEncodingException {

        String status = systemCodeService.getSystemCodeValue("sentimentJobStatus");
        if (status.equals("0")) {
            return;
        }
        if (isRun) {
            return;
        }
        /*
         * STEP 1:
         * 获取上次更新后,ID正序的20条记录
         */
        isRun = true;
        String lastUpdateId = systemCodeService.getSystemCodeValue("sentiment_last_update_id");
        if(lastUpdateId.equals("-1"))
        {
            isRun = false;
            return;
        }
        String currentUid = tblDatavTopicsMapper.selectNextInstanceId(lastUpdateId);
        if (currentUid != null) {

            List<TblDatavKeywords> datavKeywordsList = datavKeywordsService.selectAll(currentUid);

            if(datavKeywordsList.isEmpty())
            {
                systemCodeService.updateSystemCode("sentiment_last_update_id", currentUid);
                logger.info("更新最后id为:" + currentUid);
                isRun = false;
                return;
            }

            List<String> keywordList = new ArrayList<String>();
            for (TblDatavKeywords datavKeywords : datavKeywordsList) {
                keywordList.add(datavKeywords.getKeyword());
            }

            Long lastRecordId = redisCacheService.getLastSentimentId(currentUid);

            TblSearchRecordExample example = new TblSearchRecordExample();
            example.createCriteria().andMonitorKeywordsIn(keywordList);
            if(!lastRecordId.equals(0L))
            {
                example.createCriteria().andIdGreaterThan(lastRecordId);
            }
            example.setOrderByClause(" id desc");

            Integer cacheLimit = Integer.parseInt(systemCodeService.getSystemCodeValue("cache_limit"));
            if(cacheLimit.equals(0))
            {
                cacheLimit = 500;
            }

            PageHelper.startPage(1, cacheLimit);
            List<TblSearchRecord> list = tblSearchRecordMapper.selectByExample(example);


            logger.info("查询到-[" + list.size() + "]-条数据");

            if (!list.isEmpty()) {
                Collections.sort(list, new Comparator<TblSearchRecord>(){
                    public int compare(TblSearchRecord o1, TblSearchRecord o2) {

                        //id倒序
                        if(o1.getId() > o2.getId()){
                            return 1;
                        }
                        if(o1.getId().equals(o2.getId())){
                            return 0;
                        }
                        return -1;
                    }
                });

                SentimentTask.BI(list,currentUid);
                int count = tblSearchRecordMapper.countByExample(example);
                redisCacheService.setSentimentCount(currentUid,count);
            }
            systemCodeService.updateSystemCode("sentiment_last_update_id", currentUid);
            logger.info("更新最后id为:" + currentUid);
        }
        else{
            systemCodeService.updateSystemCode("sentiment_last_update_id", "-1");
        }
        isRun = false;
    }

}
