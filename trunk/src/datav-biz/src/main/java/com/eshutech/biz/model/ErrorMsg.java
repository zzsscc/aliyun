/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: ErrorMsg
 * Creator:  wanggao
 * Create-Date: 下午3:33
 **/
package com.eshutech.biz.model;

/**
 *
 * @author: Kim
 * @date: 16/10/12
 * @time: 下午3:33
 *
 */
public class ErrorMsg {
    private String success = "false";
    private String result = "";
    private String message = "";

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
