package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblLogEmail implements Serializable {
    private Integer id;

    private String emailFrom;

    private String emailTo;

    private String emailTitle;

    private String emailContent;

    private String emailBody;

    private String emailFiles;

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

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom == null ? null : emailFrom.trim();
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo == null ? null : emailTo.trim();
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public void setEmailTitle(String emailTitle) {
        this.emailTitle = emailTitle == null ? null : emailTitle.trim();
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody == null ? null : emailBody.trim();
    }

    public String getEmailFiles() {
        return emailFiles;
    }

    public void setEmailFiles(String emailFiles) {
        this.emailFiles = emailFiles == null ? null : emailFiles.trim();
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
        TblLogEmail other = (TblLogEmail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmailFrom() == null ? other.getEmailFrom() == null : this.getEmailFrom().equals(other.getEmailFrom()))
            && (this.getEmailTo() == null ? other.getEmailTo() == null : this.getEmailTo().equals(other.getEmailTo()))
            && (this.getEmailTitle() == null ? other.getEmailTitle() == null : this.getEmailTitle().equals(other.getEmailTitle()))
            && (this.getEmailContent() == null ? other.getEmailContent() == null : this.getEmailContent().equals(other.getEmailContent()))
            && (this.getEmailBody() == null ? other.getEmailBody() == null : this.getEmailBody().equals(other.getEmailBody()))
            && (this.getEmailFiles() == null ? other.getEmailFiles() == null : this.getEmailFiles().equals(other.getEmailFiles()))
            && (this.getDataStatus() == null ? other.getDataStatus() == null : this.getDataStatus().equals(other.getDataStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmailFrom() == null) ? 0 : getEmailFrom().hashCode());
        result = prime * result + ((getEmailTo() == null) ? 0 : getEmailTo().hashCode());
        result = prime * result + ((getEmailTitle() == null) ? 0 : getEmailTitle().hashCode());
        result = prime * result + ((getEmailContent() == null) ? 0 : getEmailContent().hashCode());
        result = prime * result + ((getEmailBody() == null) ? 0 : getEmailBody().hashCode());
        result = prime * result + ((getEmailFiles() == null) ? 0 : getEmailFiles().hashCode());
        result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }
}