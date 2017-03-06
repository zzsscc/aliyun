package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblSmsMt implements Serializable {
    private Integer id;

    private String mtType;

    private String mtPhone;

    private String mtMsg;

    private String mtContent;

    private String mtLinkid;

    private String mtChannel;

    private String mtStatus;

    private Date mtTime;

    private String mtCount;

    private String mtId;

    private String moStatus;

    private Date moTime;

    private String moId;

    private String dataDesc;

    private String dataStatus;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMtType() {
        return mtType;
    }

    public void setMtType(String mtType) {
        this.mtType = mtType == null ? null : mtType.trim();
    }

    public String getMtPhone() {
        return mtPhone;
    }

    public void setMtPhone(String mtPhone) {
        this.mtPhone = mtPhone == null ? null : mtPhone.trim();
    }

    public String getMtMsg() {
        return mtMsg;
    }

    public void setMtMsg(String mtMsg) {
        this.mtMsg = mtMsg == null ? null : mtMsg.trim();
    }

    public String getMtContent() {
        return mtContent;
    }

    public void setMtContent(String mtContent) {
        this.mtContent = mtContent == null ? null : mtContent.trim();
    }

    public String getMtLinkid() {
        return mtLinkid;
    }

    public void setMtLinkid(String mtLinkid) {
        this.mtLinkid = mtLinkid == null ? null : mtLinkid.trim();
    }

    public String getMtChannel() {
        return mtChannel;
    }

    public void setMtChannel(String mtChannel) {
        this.mtChannel = mtChannel == null ? null : mtChannel.trim();
    }

    public String getMtStatus() {
        return mtStatus;
    }

    public void setMtStatus(String mtStatus) {
        this.mtStatus = mtStatus == null ? null : mtStatus.trim();
    }

    public Date getMtTime() {
        return mtTime;
    }

    public void setMtTime(Date mtTime) {
        this.mtTime = mtTime;
    }

    public String getMtCount() {
        return mtCount;
    }

    public void setMtCount(String mtCount) {
        this.mtCount = mtCount == null ? null : mtCount.trim();
    }

    public String getMtId() {
        return mtId;
    }

    public void setMtId(String mtId) {
        this.mtId = mtId == null ? null : mtId.trim();
    }

    public String getMoStatus() {
        return moStatus;
    }

    public void setMoStatus(String moStatus) {
        this.moStatus = moStatus == null ? null : moStatus.trim();
    }

    public Date getMoTime() {
        return moTime;
    }

    public void setMoTime(Date moTime) {
        this.moTime = moTime;
    }

    public String getMoId() {
        return moId;
    }

    public void setMoId(String moId) {
        this.moId = moId == null ? null : moId.trim();
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc == null ? null : dataDesc.trim();
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
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
        TblSmsMt other = (TblSmsMt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMtType() == null ? other.getMtType() == null : this.getMtType().equals(other.getMtType()))
            && (this.getMtPhone() == null ? other.getMtPhone() == null : this.getMtPhone().equals(other.getMtPhone()))
            && (this.getMtMsg() == null ? other.getMtMsg() == null : this.getMtMsg().equals(other.getMtMsg()))
            && (this.getMtContent() == null ? other.getMtContent() == null : this.getMtContent().equals(other.getMtContent()))
            && (this.getMtLinkid() == null ? other.getMtLinkid() == null : this.getMtLinkid().equals(other.getMtLinkid()))
            && (this.getMtChannel() == null ? other.getMtChannel() == null : this.getMtChannel().equals(other.getMtChannel()))
            && (this.getMtStatus() == null ? other.getMtStatus() == null : this.getMtStatus().equals(other.getMtStatus()))
            && (this.getMtTime() == null ? other.getMtTime() == null : this.getMtTime().equals(other.getMtTime()))
            && (this.getMtCount() == null ? other.getMtCount() == null : this.getMtCount().equals(other.getMtCount()))
            && (this.getMtId() == null ? other.getMtId() == null : this.getMtId().equals(other.getMtId()))
            && (this.getMoStatus() == null ? other.getMoStatus() == null : this.getMoStatus().equals(other.getMoStatus()))
            && (this.getMoTime() == null ? other.getMoTime() == null : this.getMoTime().equals(other.getMoTime()))
            && (this.getMoId() == null ? other.getMoId() == null : this.getMoId().equals(other.getMoId()))
            && (this.getDataDesc() == null ? other.getDataDesc() == null : this.getDataDesc().equals(other.getDataDesc()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMtType() == null) ? 0 : getMtType().hashCode());
        result = prime * result + ((getMtPhone() == null) ? 0 : getMtPhone().hashCode());
        result = prime * result + ((getMtMsg() == null) ? 0 : getMtMsg().hashCode());
        result = prime * result + ((getMtContent() == null) ? 0 : getMtContent().hashCode());
        result = prime * result + ((getMtLinkid() == null) ? 0 : getMtLinkid().hashCode());
        result = prime * result + ((getMtChannel() == null) ? 0 : getMtChannel().hashCode());
        result = prime * result + ((getMtStatus() == null) ? 0 : getMtStatus().hashCode());
        result = prime * result + ((getMtTime() == null) ? 0 : getMtTime().hashCode());
        result = prime * result + ((getMtCount() == null) ? 0 : getMtCount().hashCode());
        result = prime * result + ((getMtId() == null) ? 0 : getMtId().hashCode());
        result = prime * result + ((getMoStatus() == null) ? 0 : getMoStatus().hashCode());
        result = prime * result + ((getMoTime() == null) ? 0 : getMoTime().hashCode());
        result = prime * result + ((getMoId() == null) ? 0 : getMoId().hashCode());
        result = prime * result + ((getDataDesc() == null) ? 0 : getDataDesc().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }
}