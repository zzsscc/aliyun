package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblWeiboAnalysis implements Serializable {
    private Integer id;

    private String instanceid;

    private String weiboUser;

    private String weiboDesc;

    private String weiboUrl;

    private Integer showStatus;

    private String analysisId;

    private String analysisResultId;

    private Date createTime;

    private Date modifyTime;

    private String weiboHeadImg;

    private String weiboCreateTime;

    private Integer repostsCount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid == null ? null : instanceid.trim();
    }

    public String getWeiboUser() {
        return weiboUser;
    }

    public void setWeiboUser(String weiboUser) {
        this.weiboUser = weiboUser == null ? null : weiboUser.trim();
    }

    public String getWeiboDesc() {
        return weiboDesc;
    }

    public void setWeiboDesc(String weiboDesc) {
        this.weiboDesc = weiboDesc == null ? null : weiboDesc.trim();
    }

    public String getWeiboUrl() {
        return weiboUrl;
    }

    public void setWeiboUrl(String weiboUrl) {
        this.weiboUrl = weiboUrl == null ? null : weiboUrl.trim();
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId == null ? null : analysisId.trim();
    }

    public String getAnalysisResultId() {
        return analysisResultId;
    }

    public void setAnalysisResultId(String analysisResultId) {
        this.analysisResultId = analysisResultId == null ? null : analysisResultId.trim();
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

    public String getWeiboHeadImg() {
        return weiboHeadImg;
    }

    public void setWeiboHeadImg(String weiboHeadImg) {
        this.weiboHeadImg = weiboHeadImg == null ? null : weiboHeadImg.trim();
    }

    public String getWeiboCreateTime() {
        return weiboCreateTime;
    }

    public void setWeiboCreateTime(String weiboCreateTime) {
        this.weiboCreateTime = weiboCreateTime == null ? null : weiboCreateTime.trim();
    }

    public Integer getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(Integer repostsCount) {
        this.repostsCount = repostsCount;
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
        TblWeiboAnalysis other = (TblWeiboAnalysis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInstanceid() == null ? other.getInstanceid() == null : this.getInstanceid().equals(other.getInstanceid()))
            && (this.getWeiboUser() == null ? other.getWeiboUser() == null : this.getWeiboUser().equals(other.getWeiboUser()))
            && (this.getWeiboDesc() == null ? other.getWeiboDesc() == null : this.getWeiboDesc().equals(other.getWeiboDesc()))
            && (this.getWeiboUrl() == null ? other.getWeiboUrl() == null : this.getWeiboUrl().equals(other.getWeiboUrl()))
            && (this.getShowStatus() == null ? other.getShowStatus() == null : this.getShowStatus().equals(other.getShowStatus()))
            && (this.getAnalysisId() == null ? other.getAnalysisId() == null : this.getAnalysisId().equals(other.getAnalysisId()))
            && (this.getAnalysisResultId() == null ? other.getAnalysisResultId() == null : this.getAnalysisResultId().equals(other.getAnalysisResultId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getWeiboHeadImg() == null ? other.getWeiboHeadImg() == null : this.getWeiboHeadImg().equals(other.getWeiboHeadImg()))
            && (this.getWeiboCreateTime() == null ? other.getWeiboCreateTime() == null : this.getWeiboCreateTime().equals(other.getWeiboCreateTime()))
            && (this.getRepostsCount() == null ? other.getRepostsCount() == null : this.getRepostsCount().equals(other.getRepostsCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInstanceid() == null) ? 0 : getInstanceid().hashCode());
        result = prime * result + ((getWeiboUser() == null) ? 0 : getWeiboUser().hashCode());
        result = prime * result + ((getWeiboDesc() == null) ? 0 : getWeiboDesc().hashCode());
        result = prime * result + ((getWeiboUrl() == null) ? 0 : getWeiboUrl().hashCode());
        result = prime * result + ((getShowStatus() == null) ? 0 : getShowStatus().hashCode());
        result = prime * result + ((getAnalysisId() == null) ? 0 : getAnalysisId().hashCode());
        result = prime * result + ((getAnalysisResultId() == null) ? 0 : getAnalysisResultId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getWeiboHeadImg() == null) ? 0 : getWeiboHeadImg().hashCode());
        result = prime * result + ((getWeiboCreateTime() == null) ? 0 : getWeiboCreateTime().hashCode());
        result = prime * result + ((getRepostsCount() == null) ? 0 : getRepostsCount().hashCode());
        return result;
    }
}