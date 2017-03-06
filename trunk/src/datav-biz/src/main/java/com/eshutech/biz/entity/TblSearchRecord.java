package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblSearchRecord implements Serializable {

    private String instanceId;

    private Long id;

    private Long productId;

    private Long spiderTopicId;

    private Long monitorKeywordId;

    private String monitorKeywords;

    private Long monitorTopicId;

    private String from;

    private String url;

    private Integer filterStatus;

    private Date createdAt;

    private Date pubTime;

    private Long wbId;

    private Long wbUserId;

    private Integer wbFansCount;

    private Integer wbRepostCount;

    private Integer wbCommentCount;

    private Integer wbLikeCount;

    private Integer wbVerifiedType;

    private Integer wbType;

    private Integer emotionTendency;

    private Integer emotionScore;

    private String urlMD5;

    private String tags;

    private String langType;

    private String subject;

    private String description;

    private String translateSubject;

    private String translateDescription;

    private Integer clusterId;

    private Integer priority;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSpiderTopicId() {
        return spiderTopicId;
    }

    public void setSpiderTopicId(Long spiderTopicId) {
        this.spiderTopicId = spiderTopicId;
    }

    public Long getMonitorKeywordId() {
        return monitorKeywordId;
    }

    public void setMonitorKeywordId(Long monitorKeywordId) {
        this.monitorKeywordId = monitorKeywordId;
    }

    public String getMonitorKeywords() {
        return monitorKeywords;
    }

    public void setMonitorKeywords(String monitorKeywords) {
        this.monitorKeywords = monitorKeywords == null ? null : monitorKeywords.trim();
    }

    public Long getMonitorTopicId() {
        return monitorTopicId;
    }

    public void setMonitorTopicId(Long monitorTopicId) {
        this.monitorTopicId = monitorTopicId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(Integer filterStatus) {
        this.filterStatus = filterStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Long getWbId() {
        return wbId;
    }

    public void setWbId(Long wbId) {
        this.wbId = wbId;
    }

    public Long getWbUserId() {
        return wbUserId;
    }

    public void setWbUserId(Long wbUserId) {
        this.wbUserId = wbUserId;
    }

    public Integer getWbFansCount() {
        return wbFansCount;
    }

    public void setWbFansCount(Integer wbFansCount) {
        this.wbFansCount = wbFansCount;
    }

    public Integer getWbRepostCount() {
        return wbRepostCount;
    }

    public void setWbRepostCount(Integer wbRepostCount) {
        this.wbRepostCount = wbRepostCount;
    }

    public Integer getWbCommentCount() {
        return wbCommentCount;
    }

    public void setWbCommentCount(Integer wbCommentCount) {
        this.wbCommentCount = wbCommentCount;
    }

    public Integer getWbLikeCount() {
        return wbLikeCount;
    }

    public void setWbLikeCount(Integer wbLikeCount) {
        this.wbLikeCount = wbLikeCount;
    }

    public Integer getWbVerifiedType() {
        return wbVerifiedType;
    }

    public void setWbVerifiedType(Integer wbVerifiedType) {
        this.wbVerifiedType = wbVerifiedType;
    }

    public Integer getWbType() {
        return wbType;
    }

    public void setWbType(Integer wbType) {
        this.wbType = wbType;
    }

    public Integer getEmotionTendency() {
        return emotionTendency;
    }

    public void setEmotionTendency(Integer emotionTendency) {
        this.emotionTendency = emotionTendency;
    }

    public Integer getEmotionScore() {
        return emotionScore;
    }

    public void setEmotionScore(Integer emotionScore) {
        this.emotionScore = emotionScore;
    }

    public String getUrlMD5() {
        return urlMD5;
    }

    public void setUrlMD5(String urlMD5) {
        this.urlMD5 = urlMD5 == null ? null : urlMD5.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType == null ? null : langType.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTranslateSubject() {
        return translateSubject;
    }

    public void setTranslateSubject(String translateSubject) {
        this.translateSubject = translateSubject == null ? null : translateSubject.trim();
    }

    public String getTranslateDescription() {
        return translateDescription;
    }

    public void setTranslateDescription(String translateDescription) {
        this.translateDescription = translateDescription == null ? null : translateDescription.trim();
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TblSearchRecord other = (TblSearchRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSpiderTopicId() == null ? other.getSpiderTopicId() == null : this.getSpiderTopicId().equals(other.getSpiderTopicId()))
            && (this.getMonitorKeywordId() == null ? other.getMonitorKeywordId() == null : this.getMonitorKeywordId().equals(other.getMonitorKeywordId()))
            && (this.getMonitorKeywords() == null ? other.getMonitorKeywords() == null : this.getMonitorKeywords().equals(other.getMonitorKeywords()))
            && (this.getMonitorTopicId() == null ? other.getMonitorTopicId() == null : this.getMonitorTopicId().equals(other.getMonitorTopicId()))
            && (this.getFrom() == null ? other.getFrom() == null : this.getFrom().equals(other.getFrom()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getFilterStatus() == null ? other.getFilterStatus() == null : this.getFilterStatus().equals(other.getFilterStatus()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getPubTime() == null ? other.getPubTime() == null : this.getPubTime().equals(other.getPubTime()))
            && (this.getWbId() == null ? other.getWbId() == null : this.getWbId().equals(other.getWbId()))
            && (this.getWbUserId() == null ? other.getWbUserId() == null : this.getWbUserId().equals(other.getWbUserId()))
            && (this.getWbFansCount() == null ? other.getWbFansCount() == null : this.getWbFansCount().equals(other.getWbFansCount()))
            && (this.getWbRepostCount() == null ? other.getWbRepostCount() == null : this.getWbRepostCount().equals(other.getWbRepostCount()))
            && (this.getWbCommentCount() == null ? other.getWbCommentCount() == null : this.getWbCommentCount().equals(other.getWbCommentCount()))
            && (this.getWbLikeCount() == null ? other.getWbLikeCount() == null : this.getWbLikeCount().equals(other.getWbLikeCount()))
            && (this.getWbVerifiedType() == null ? other.getWbVerifiedType() == null : this.getWbVerifiedType().equals(other.getWbVerifiedType()))
            && (this.getWbType() == null ? other.getWbType() == null : this.getWbType().equals(other.getWbType()))
            && (this.getEmotionTendency() == null ? other.getEmotionTendency() == null : this.getEmotionTendency().equals(other.getEmotionTendency()))
            && (this.getEmotionScore() == null ? other.getEmotionScore() == null : this.getEmotionScore().equals(other.getEmotionScore()))
            && (this.getUrlMD5() == null ? other.getUrlMD5() == null : this.getUrlMD5().equals(other.getUrlMD5()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getLangType() == null ? other.getLangType() == null : this.getLangType().equals(other.getLangType()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getTranslateSubject() == null ? other.getTranslateSubject() == null : this.getTranslateSubject().equals(other.getTranslateSubject()))
            && (this.getTranslateDescription() == null ? other.getTranslateDescription() == null : this.getTranslateDescription().equals(other.getTranslateDescription()))
            && (this.getClusterId() == null ? other.getClusterId() == null : this.getClusterId().equals(other.getClusterId()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSpiderTopicId() == null) ? 0 : getSpiderTopicId().hashCode());
        result = prime * result + ((getMonitorKeywordId() == null) ? 0 : getMonitorKeywordId().hashCode());
        result = prime * result + ((getMonitorKeywords() == null) ? 0 : getMonitorKeywords().hashCode());
        result = prime * result + ((getMonitorTopicId() == null) ? 0 : getMonitorTopicId().hashCode());
        result = prime * result + ((getFrom() == null) ? 0 : getFrom().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getFilterStatus() == null) ? 0 : getFilterStatus().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getPubTime() == null) ? 0 : getPubTime().hashCode());
        result = prime * result + ((getWbId() == null) ? 0 : getWbId().hashCode());
        result = prime * result + ((getWbUserId() == null) ? 0 : getWbUserId().hashCode());
        result = prime * result + ((getWbFansCount() == null) ? 0 : getWbFansCount().hashCode());
        result = prime * result + ((getWbRepostCount() == null) ? 0 : getWbRepostCount().hashCode());
        result = prime * result + ((getWbCommentCount() == null) ? 0 : getWbCommentCount().hashCode());
        result = prime * result + ((getWbLikeCount() == null) ? 0 : getWbLikeCount().hashCode());
        result = prime * result + ((getWbVerifiedType() == null) ? 0 : getWbVerifiedType().hashCode());
        result = prime * result + ((getWbType() == null) ? 0 : getWbType().hashCode());
        result = prime * result + ((getEmotionTendency() == null) ? 0 : getEmotionTendency().hashCode());
        result = prime * result + ((getEmotionScore() == null) ? 0 : getEmotionScore().hashCode());
        result = prime * result + ((getUrlMD5() == null) ? 0 : getUrlMD5().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getLangType() == null) ? 0 : getLangType().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getTranslateSubject() == null) ? 0 : getTranslateSubject().hashCode());
        result = prime * result + ((getTranslateDescription() == null) ? 0 : getTranslateDescription().hashCode());
        result = prime * result + ((getClusterId() == null) ? 0 : getClusterId().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        return result;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}