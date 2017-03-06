package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblIsvInstances implements Serializable {
    private String instanceId;

    private Integer uid;

    private String aliUid;

    private String orderBizId;

    private String orderId;

    private String skuId;

    private String accountQuantity;

    private String expiredOn;

    private String template;

    private String corpId;

    private String email;

    private String mobile;

    private Date createTime;

    private Date modifyTime;

    private Integer keywordLimit;

    private Integer topicLimit;

    private Integer weiboAnalysis;

    private Integer sentimentLimit;

    private static final long serialVersionUID = 1L;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAliUid() {
        return aliUid;
    }

    public void setAliUid(String aliUid) {
        this.aliUid = aliUid == null ? null : aliUid.trim();
    }

    public String getOrderBizId() {
        return orderBizId;
    }

    public void setOrderBizId(String orderBizId) {
        this.orderBizId = orderBizId == null ? null : orderBizId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
    }

    public String getAccountQuantity() {
        return accountQuantity;
    }

    public void setAccountQuantity(String accountQuantity) {
        this.accountQuantity = accountQuantity == null ? null : accountQuantity.trim();
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn == null ? null : expiredOn.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getKeywordLimit() {
        return keywordLimit;
    }

    public void setKeywordLimit(Integer keywordLimit) {
        this.keywordLimit = keywordLimit;
    }

    public Integer getTopicLimit() {
        return topicLimit;
    }

    public void setTopicLimit(Integer topicLimit) {
        this.topicLimit = topicLimit;
    }

    public Integer getWeiboAnalysis() {
        return weiboAnalysis;
    }

    public void setWeiboAnalysis(Integer weiboAnalysis) {
        this.weiboAnalysis = weiboAnalysis;
    }

    public Integer getSentimentLimit() {
        return sentimentLimit;
    }

    public void setSentimentLimit(Integer sentimentLimit) {
        this.sentimentLimit = sentimentLimit;
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
        TblIsvInstances other = (TblIsvInstances) that;
        return (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getAliUid() == null ? other.getAliUid() == null : this.getAliUid().equals(other.getAliUid()))
            && (this.getOrderBizId() == null ? other.getOrderBizId() == null : this.getOrderBizId().equals(other.getOrderBizId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSkuId() == null ? other.getSkuId() == null : this.getSkuId().equals(other.getSkuId()))
            && (this.getAccountQuantity() == null ? other.getAccountQuantity() == null : this.getAccountQuantity().equals(other.getAccountQuantity()))
            && (this.getExpiredOn() == null ? other.getExpiredOn() == null : this.getExpiredOn().equals(other.getExpiredOn()))
            && (this.getTemplate() == null ? other.getTemplate() == null : this.getTemplate().equals(other.getTemplate()))
            && (this.getCorpId() == null ? other.getCorpId() == null : this.getCorpId().equals(other.getCorpId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getKeywordLimit() == null ? other.getKeywordLimit() == null : this.getKeywordLimit().equals(other.getKeywordLimit()))
            && (this.getTopicLimit() == null ? other.getTopicLimit() == null : this.getTopicLimit().equals(other.getTopicLimit()))
            && (this.getWeiboAnalysis() == null ? other.getWeiboAnalysis() == null : this.getWeiboAnalysis().equals(other.getWeiboAnalysis()))
            && (this.getSentimentLimit() == null ? other.getSentimentLimit() == null : this.getSentimentLimit().equals(other.getSentimentLimit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getAliUid() == null) ? 0 : getAliUid().hashCode());
        result = prime * result + ((getOrderBizId() == null) ? 0 : getOrderBizId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSkuId() == null) ? 0 : getSkuId().hashCode());
        result = prime * result + ((getAccountQuantity() == null) ? 0 : getAccountQuantity().hashCode());
        result = prime * result + ((getExpiredOn() == null) ? 0 : getExpiredOn().hashCode());
        result = prime * result + ((getTemplate() == null) ? 0 : getTemplate().hashCode());
        result = prime * result + ((getCorpId() == null) ? 0 : getCorpId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getKeywordLimit() == null) ? 0 : getKeywordLimit().hashCode());
        result = prime * result + ((getTopicLimit() == null) ? 0 : getTopicLimit().hashCode());
        result = prime * result + ((getWeiboAnalysis() == null) ? 0 : getWeiboAnalysis().hashCode());
        result = prime * result + ((getSentimentLimit() == null) ? 0 : getSentimentLimit().hashCode());
        return result;
    }
}