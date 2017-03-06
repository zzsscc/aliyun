package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblInstanceProfile extends TblInstanceProfileKey implements Serializable {
    private Integer sentimentCount;

    private Integer weiboAnalysisCount;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

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
        TblInstanceProfile other = (TblInstanceProfile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getSentimentCount() == null ? other.getSentimentCount() == null : this.getSentimentCount().equals(other.getSentimentCount()))
            && (this.getWeiboAnalysisCount() == null ? other.getWeiboAnalysisCount() == null : this.getWeiboAnalysisCount().equals(other.getWeiboAnalysisCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        result = prime * result + ((getSentimentCount() == null) ? 0 : getSentimentCount().hashCode());
        result = prime * result + ((getWeiboAnalysisCount() == null) ? 0 : getWeiboAnalysisCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }
}