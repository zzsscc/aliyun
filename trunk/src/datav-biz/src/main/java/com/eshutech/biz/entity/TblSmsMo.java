package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblSmsMo implements Serializable {
    private Integer id;

    private String moPhone;

    private String moContent;

    private String moNumber;

    private Date moTime;

    private String moMemo;

    private String moChannel;

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

    public String getMoPhone() {
        return moPhone;
    }

    public void setMoPhone(String moPhone) {
        this.moPhone = moPhone == null ? null : moPhone.trim();
    }

    public String getMoContent() {
        return moContent;
    }

    public void setMoContent(String moContent) {
        this.moContent = moContent == null ? null : moContent.trim();
    }

    public String getMoNumber() {
        return moNumber;
    }

    public void setMoNumber(String moNumber) {
        this.moNumber = moNumber == null ? null : moNumber.trim();
    }

    public Date getMoTime() {
        return moTime;
    }

    public void setMoTime(Date moTime) {
        this.moTime = moTime;
    }

    public String getMoMemo() {
        return moMemo;
    }

    public void setMoMemo(String moMemo) {
        this.moMemo = moMemo == null ? null : moMemo.trim();
    }

    public String getMoChannel() {
        return moChannel;
    }

    public void setMoChannel(String moChannel) {
        this.moChannel = moChannel == null ? null : moChannel.trim();
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
        TblSmsMo other = (TblSmsMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMoPhone() == null ? other.getMoPhone() == null : this.getMoPhone().equals(other.getMoPhone()))
            && (this.getMoContent() == null ? other.getMoContent() == null : this.getMoContent().equals(other.getMoContent()))
            && (this.getMoNumber() == null ? other.getMoNumber() == null : this.getMoNumber().equals(other.getMoNumber()))
            && (this.getMoTime() == null ? other.getMoTime() == null : this.getMoTime().equals(other.getMoTime()))
            && (this.getMoMemo() == null ? other.getMoMemo() == null : this.getMoMemo().equals(other.getMoMemo()))
            && (this.getMoChannel() == null ? other.getMoChannel() == null : this.getMoChannel().equals(other.getMoChannel()))
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
        result = prime * result + ((getMoPhone() == null) ? 0 : getMoPhone().hashCode());
        result = prime * result + ((getMoContent() == null) ? 0 : getMoContent().hashCode());
        result = prime * result + ((getMoNumber() == null) ? 0 : getMoNumber().hashCode());
        result = prime * result + ((getMoTime() == null) ? 0 : getMoTime().hashCode());
        result = prime * result + ((getMoMemo() == null) ? 0 : getMoMemo().hashCode());
        result = prime * result + ((getMoChannel() == null) ? 0 : getMoChannel().hashCode());
        result = prime * result + ((getDataDesc() == null) ? 0 : getDataDesc().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }
}