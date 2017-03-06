/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: PublicSentimentParam
 * Creator:  wanggao
 * Create-Date: 下午1:50
 **/
package com.eshutech.biz.model.aliyun;

/**
 *
 * @author: Kim
 * @date: 16/10/11
 * @time: 下午1:50
 *
 */
public class BrandSentimentParam extends BaseParam {
    /*
     * 模糊匹配标题内容
     */
    protected String subject="";
    /*
     * 模糊匹配全文（标题+正文）
     */
    protected String description="";
    /*
     * 源站名称，如：新浪网、百度贴吧、微博名
     */
    protected String from="";
    /*
     * 抓取类型。请参考：getKeywords中返回的spiderTopics的ID属性
     */
    protected String spiderTopicId="";
    /*
     * 关键词专题。请参考：getKeywords中返回的topicId属性
     */
    protected String monitorTopicId="";
    /*
     * 情感趋势，1 正面，0 中性，-1 负面。
     */
    protected String emotionTendencys="";
    /*
     * 查询相似的舆情数据。一个cluster表示一批相似数据，同一批相似舆情的clusterId为同一个，clusterId为中心点舆情的主键。
     */
    protected String clusterId="";
    /*
     * 抓取开始时间（>=），格式 2016-04-28 13:30:41
     */
    protected String createdAtBegin="";
    /*
     * 抓取结束时间（<=），格式 2016-04-28 13:30:41
     */
    protected String createdAtEnd="";
    /*
     * 舆情发布时间（>=），格式 2016-04-28 13:30:41
     */
    protected String pubTimeBegin="";
    /*
     * 舆情结束时间（<=），格式 2016-04-28 13:30:41
     */
    protected String pubTimeEnd="";
    /*
     * 用于分页查询。当前页码，不传默认值:1
     */
    protected String toPage="";
    /*
     * 用于分页查询。每页显示条数。默认值为:20。
     */
    protected String pageSize="";


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSpiderTopicId() {
        return spiderTopicId;
    }

    public void setSpiderTopicId(String spiderTopicId) {
        this.spiderTopicId = spiderTopicId;
    }

    public String getMonitorTopicId() {
        return monitorTopicId;
    }

    public void setMonitorTopicId(String monitorTopicId) {
        this.monitorTopicId = monitorTopicId;
    }

    public String getEmotionTendencys() {
        return emotionTendencys;
    }

    public void setEmotionTendencys(String emotionTendencys) {
        this.emotionTendencys = emotionTendencys;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getCreatedAtBegin() {
        return createdAtBegin;
    }

    public void setCreatedAtBegin(String createdAtBegin) {
        this.createdAtBegin = createdAtBegin;
    }

    public String getCreatedAtEnd() {
        return createdAtEnd;
    }

    public void setCreatedAtEnd(String createdAtEnd) {
        this.createdAtEnd = createdAtEnd;
    }

    public String getPubTimeBegin() {
        return pubTimeBegin;
    }

    public void setPubTimeBegin(String pubTimeBegin) {
        this.pubTimeBegin = pubTimeBegin;
    }

    public String getPubTimeEnd() {
        return pubTimeEnd;
    }

    public void setPubTimeEnd(String pubTimeEnd) {
        this.pubTimeEnd = pubTimeEnd;
    }

    public String getToPage() {
        return toPage;
    }

    public void setToPage(String toPage) {
        this.toPage = toPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
