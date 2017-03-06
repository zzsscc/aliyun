/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: KeywordResponse
 * Creator:  wanggao
 * Create-Date: 下午2:12
 **/
package com.eshutech.biz.model;

import com.eshutech.biz.entity.AliKeyword;

import java.util.List;

/**
 *
 * @author: Kim
 * @date: 16/11/18
 * @time: 下午2:12
 *
 */
public class KeywordResponse {

    private Integer pageSize;
    private Integer toPage;
    private Integer totalCount;
    private Integer totalPages;
    private Boolean success;
    private String errorCode;
    private String other;
    private String msgCode;
    private String msgInfo;
    private List messages;
    private List<AliKeyword> result;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getToPage() {
        return toPage;
    }

    public void setToPage(Integer toPage) {
        this.toPage = toPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

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

    public List<AliKeyword> getResult() {
        return result;
    }

    public void setResult(List<AliKeyword> result) {
        this.result = result;
    }
}
