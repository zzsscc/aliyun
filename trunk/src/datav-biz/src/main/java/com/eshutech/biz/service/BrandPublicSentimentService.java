/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: BrandPublicSentimentService
 * Creator:  wanggao
 * Create-Date: 下午8:09
 **/
package com.eshutech.biz.service;

import com.eshutech.biz.model.aliyun.BrandSentimentParam;

/**
 * 品牌舆情
 * @author: Kim
 * @date: 16/10/19
 * @time: 下午8:09
 *
 */
public interface BrandPublicSentimentService {

    /**
     * 获取微博分析结果
     * @param instanceId
     * @return
     */
    public String weiboAnalysisResult(String instanceId);
    /**
     * 根据分析的ID获取分析的结果
     * @param analysisId
     * @return
     */
    public String weiboAnalysisResultWithId(String analysisId);
    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportNumber(String keyWordTopicId,String time,String timeType);
    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportEmotion(String keyWordTopicId,String time,String timeType);
    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportHotWord(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportHotEvent(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportTopic(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportKeyWord(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportTagAnalysis(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportNumberTrend(String keyWordTopicId,String time,String timeType);

    /**
     *
     * @param keyWordTopicId
     * @param time
     * @param timeType
     * @return
     */
    public String queryReportEmotionTrend(String keyWordTopicId,String time,String timeType);

    /**
     * 根据实例ID得到舆情数据
     * @param instanceId
     * @return
     */
    public String search(String instanceId, BrandSentimentParam param);

    public void queryTopicsList();

    public void getKeywords(Integer topicId);
}
