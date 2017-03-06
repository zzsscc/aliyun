package com.eshutech.biz.entity;

import java.io.Serializable;
import java.util.Date;

public class TblLogException implements Serializable {
    private Integer id;

    private String loggerType;

    private String loggerDesc;

    private String loggerSeesion;

    private String loggerLinkid;

    private String loggerIp;

    private String loggerAgent;

    private String loggerContent;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoggerType() {
        return loggerType;
    }

    public void setLoggerType(String loggerType) {
        this.loggerType = loggerType == null ? null : loggerType.trim();
    }

    public String getLoggerDesc() {
        return loggerDesc;
    }

    public void setLoggerDesc(String loggerDesc) {
        this.loggerDesc = loggerDesc == null ? null : loggerDesc.trim();
    }

    public String getLoggerSeesion() {
        return loggerSeesion;
    }

    public void setLoggerSeesion(String loggerSeesion) {
        this.loggerSeesion = loggerSeesion == null ? null : loggerSeesion.trim();
    }

    public String getLoggerLinkid() {
        return loggerLinkid;
    }

    public void setLoggerLinkid(String loggerLinkid) {
        this.loggerLinkid = loggerLinkid == null ? null : loggerLinkid.trim();
    }

    public String getLoggerIp() {
        return loggerIp;
    }

    public void setLoggerIp(String loggerIp) {
        this.loggerIp = loggerIp == null ? null : loggerIp.trim();
    }

    public String getLoggerAgent() {
        return loggerAgent;
    }

    public void setLoggerAgent(String loggerAgent) {
        this.loggerAgent = loggerAgent == null ? null : loggerAgent.trim();
    }

    public String getLoggerContent() {
        return loggerContent;
    }

    public void setLoggerContent(String loggerContent) {
        this.loggerContent = loggerContent == null ? null : loggerContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        TblLogException other = (TblLogException) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoggerType() == null ? other.getLoggerType() == null : this.getLoggerType().equals(other.getLoggerType()))
            && (this.getLoggerDesc() == null ? other.getLoggerDesc() == null : this.getLoggerDesc().equals(other.getLoggerDesc()))
            && (this.getLoggerSeesion() == null ? other.getLoggerSeesion() == null : this.getLoggerSeesion().equals(other.getLoggerSeesion()))
            && (this.getLoggerLinkid() == null ? other.getLoggerLinkid() == null : this.getLoggerLinkid().equals(other.getLoggerLinkid()))
            && (this.getLoggerIp() == null ? other.getLoggerIp() == null : this.getLoggerIp().equals(other.getLoggerIp()))
            && (this.getLoggerAgent() == null ? other.getLoggerAgent() == null : this.getLoggerAgent().equals(other.getLoggerAgent()))
            && (this.getLoggerContent() == null ? other.getLoggerContent() == null : this.getLoggerContent().equals(other.getLoggerContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoggerType() == null) ? 0 : getLoggerType().hashCode());
        result = prime * result + ((getLoggerDesc() == null) ? 0 : getLoggerDesc().hashCode());
        result = prime * result + ((getLoggerSeesion() == null) ? 0 : getLoggerSeesion().hashCode());
        result = prime * result + ((getLoggerLinkid() == null) ? 0 : getLoggerLinkid().hashCode());
        result = prime * result + ((getLoggerIp() == null) ? 0 : getLoggerIp().hashCode());
        result = prime * result + ((getLoggerAgent() == null) ? 0 : getLoggerAgent().hashCode());
        result = prime * result + ((getLoggerContent() == null) ? 0 : getLoggerContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}