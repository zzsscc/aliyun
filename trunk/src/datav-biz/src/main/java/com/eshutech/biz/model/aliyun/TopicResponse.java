/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: TopicResponse
 * Creator:  wanggao
 * Create-Date: 下午2:10
 **/
package com.eshutech.biz.model.aliyun;

import com.eshutech.biz.entity.AliTopic;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/18
 * @time: 下午2:10
 *
 */
public class TopicResponse {
    private Boolean success;
    private String  errorCode;
    private String other;
    private String msgCode;
    private String msgInfo;
    private List messages;
    private List<AliTopic> result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public List getMessages() {
        return messages;
    }

    public void setMessages(List messages) {
        this.messages = messages;
    }

    public List<AliTopic> getResult() {
        return result;
    }

    public void setResult(List<AliTopic> result) {
        this.result = result;
    }
}
