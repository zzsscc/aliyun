/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: SearchService
 * Creator:  wanggao
 * Create-Date: 下午2:56
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblSearchRecord;
import com.eshutech.biz.model.aliyun.BrandSentimentParam;
import com.eshutech.biz.model.ErrorMsg;
import com.eshutech.biz.model.aliyun.SearchResponse;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/31
 * @time: 下午2:56
 *
 */
public interface SearchService {
    /**
     * 批量插入
     * @param list
     * @return
     */
    public ErrorMsg batchInsert(List<TblSearchRecord> list);

    /**
     * 根据专题id获取所有舆情数据
     * @param instanceId
     * @return
     */
    public SearchResponse searchByInstanceId(String instanceId, BrandSentimentParam param);

}
