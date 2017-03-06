/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: UserVo
 * Creator:  wanggao
 * Create-Date: 下午4:17
 **/
package com.eshutech.biz.model.vo;

/**
 * @author: Kim
 * @date: 16/11/16
 * @time: 下午4:17
 */
public class UserVo {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAliUid() {
        return aliUid;
    }

    public void setAliUid(String aliUid) {
        this.aliUid = aliUid;
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String username;
    private String aliUid;
    private String expiredOn;
    private String modifyTime;
    private String mobile;
    private Integer id;
    private Integer sentimentCount;
    private Integer weiboAnalysisCount;
    private Integer keywordCount;
    private Integer topicCount;




    public Integer getKeywordCount() {
        return keywordCount;
    }

    public void setKeywordCount(Integer keywordCount) {
        this.keywordCount = keywordCount;
    }

    public Integer getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(Integer topicCount) {
        this.topicCount = topicCount;
    }

    public Integer getSentimentCount() {
        return sentimentCount;
    }

    public void setSentimentCount(Integer sentimentCount) {
        this.sentimentCount = sentimentCount;
    }

    public Integer getWeiboAnalysisCount() {
        return weiboAnalysisCount;
    }

    public void setWeiboAnalysisCount(Integer weiboAnalysisCount) {
        this.weiboAnalysisCount = weiboAnalysisCount;
    }
}
