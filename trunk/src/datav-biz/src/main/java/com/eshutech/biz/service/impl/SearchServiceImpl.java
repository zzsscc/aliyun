/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SearchServiceImpl
 * Creator:  wanggao
 * Create-Date: 下午2:57
 **/
package com.eshutech.biz.service.impl;

import com.eshutech.biz.cache.rediscache.IRedisCacheService;
import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.entity.TblSearchRecordExample;
import com.eshutech.biz.mapper.TblDatavKeywordsMapper;
import com.eshutech.biz.mapper.TblDatavTopicsMapper;
import com.eshutech.biz.mapper.TblSearchRecordMapper;
import com.eshutech.biz.model.aliyun.BrandSentimentParam;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.aliyun.SearchResponse;
import com.eshutech.biz.model.aliyun.SearchResult;
import com.eshutech.biz.service.DatavKeywordsService;
import com.eshutech.biz.service.SearchService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: Kim
 * @date: 16/10/31
 * @time: 下午2:57
 */
@Service
public class SearchServiceImpl implements SearchService {

    private static Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Resource
    TblSearchRecordMapper tblSearchRecordMapper;

    @Resource
    TblDatavTopicsMapper tblDatavTopicsMapper;

    @Resource
    TblDatavKeywordsMapper tblDatavKeywordsMapper;

    @Resource
    DatavKeywordsService datavKeywordsService;

    @Resource
    IRedisCacheService redisCacheService;


    @Override
    public ErrorMsg batchInsert(List<TblSearchRecord> list) {
        ErrorMsg errorMsg = new ErrorMsg();
        StringBuilder msg = new StringBuilder();
        msg.append("批量插入").append(list.size()).append("条记录,");
        int successCount = 0;
        int result = tblSearchRecordMapper.batchInsert(list);
        if (result != 0) {
            successCount += list.size();
        }
        msg.append("成功").append(successCount).append("条");

        logger.info(msg.toString());
        errorMsg.setSuccess("true");
        errorMsg.setResult(msg.toString());
        return errorMsg;
    }

    /**
     * 获取舆情数据
     *
     * @param instanceId
     * @return
     */
    @Override
    public SearchResponse searchByInstanceId(String instanceId, BrandSentimentParam param) {

        SearchResponse searchResponse = new SearchResponse();
        SearchResult searchResult = new SearchResult();
        int toPage = Integer.parseInt(param.getToPage());
        int pageSize = Integer.parseInt(param.getPageSize());
        searchResponse.setPageSize(pageSize);
        searchResponse.setToPage(toPage);

        Integer totalCount = 0;
        Integer totalPage;

        List<TblSearchRecord> result = null;
        try {
            result = redisCacheService.getSentiment(instanceId, pageSize, toPage);
            searchResult.setRecords(result);
            totalCount = redisCacheService.getSentimentCount(instanceId).intValue();
        }catch (Exception e){
            logger.info(ExceptionUtils.getStackTrace(e));
        }

        if (null == result) {
            /*
             * STEP 1:获取专题下面所有的关键字
             */
            List<TblDatavKeywords> keywordsList = datavKeywordsService.selectAll(instanceId);
            if (!keywordsList.isEmpty()) {
                /*
                 * STEP 2:获取每个关键字下的舆情数据
                 */
                List<String> monitorKeywords = new ArrayList<String>();
                for (TblDatavKeywords datavKeywords : keywordsList) {
                    monitorKeywords.add(datavKeywords.getKeyword());
                }

                //TODO:需要判断下关键字添加的时间,只取关键字添加以后的舆情数据
                TblSearchRecordExample searchRecordExample = new TblSearchRecordExample();
                searchRecordExample.createCriteria().andMonitorKeywordsIn(monitorKeywords);
                searchRecordExample.setOrderByClause("id desc");
                PageHelper.startPage(toPage, pageSize);
                result = tblSearchRecordMapper.selectByExample(searchRecordExample);
                searchResult.setRecords(result);
                totalCount = tblSearchRecordMapper.countByExample(searchRecordExample);

                searchResponse.setTotalPages((int) Math.ceil(totalCount / pageSize));
            } else {
                searchResult.setRecords(new ArrayList<TblSearchRecord>());
                searchResponse.setResult(searchResult);
            }
        }
        searchResponse.setResult(searchResult);
        totalPage = (int) Math.ceil(totalCount / pageSize);
        searchResponse.setTotalCount(totalCount);
        searchResponse.setTotalPages(totalPage);
        searchResponse.setSuccess(true);
        return searchResponse;
    }
}
