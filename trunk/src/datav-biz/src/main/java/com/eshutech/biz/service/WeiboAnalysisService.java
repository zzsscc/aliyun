/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: WeiboAnalysisService
 * Creator:  wanggao
 * Create-Date: 下午12:13
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.entity.TblWeiboAnalysis;
import com.eshutech.biz.model.ErrorMsg;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午12:13
 *
 */
public interface WeiboAnalysisService {

    /**
     * 插入微博
     * @param instanceId
     * @param weiboUrl
     * @return
     */
    public ErrorMsg insertAnalysis(String instanceId,String weiboUrl);

    /**
     * 获取分析列表
     * @param instanceId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<TblWeiboAnalysis> queryAnalysises(String instanceId,int pageNum,int pageSize);

    /**
     * 更新是否大屏展示
     * @param id
     * @param status
     * @return
     */
    public ErrorMsg updateAnalysis(Integer id, Integer status);

    /**
     * 删除分析
     * @param id
     * @return
     */
    public ErrorMsg deleteAnalysis(Integer id);

    /**
     * 微博分析或重新分析
     * @param id
     * @return
     */
    public ErrorMsg refreshAnalysis(Integer id);


    /**
     * 获取记录总数
     * @param instance
     * @return
     */
    public int count(String instance);

    /**
     * 根据分析记录的ID,获取微博分析记录
     * @param instanceId
     * @param analysisId
     * @return
     */
    public TblWeiboAnalysis queryAnalysisesById(String instanceId,String analysisId);

    public Integer checkAnalysisCount(String instanceId,String url);
}
