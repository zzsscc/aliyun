/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: IDatavKeywordsService
 * Creator:  wanggao
 * Create-Date: 下午2:05
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblDatavKeywords;
import com.eshutech.biz.model.ErrorMsg;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/18
 * @time: 下午2:05
 *
 */
public interface DatavKeywordsService {
    /**
     * 插入关键词
     * @param keyword
     * @param topicId
     * @return
     */
    public ErrorMsg insertKeyword(String keyword,Integer topicId,String siteTypeIds);

    /**
     * 获取专题下所有的关键词
     * @param topicId
     * @return
     */
    public List<TblDatavKeywords> queryKeywords(Integer topicId,int pageNum,int pageSize);

    /**
     * 删除关键词
     * @param ids
     * @return
     */
    public ErrorMsg deleteKeyword(String ids);

    public ErrorMsg updateKeyword(String keyword,Integer id,String siteTypeIds);

    public int count(Integer topicId);

    public int countAll(String instanceId);

    public List<TblDatavKeywords> selectAll(String instanceId);



}
