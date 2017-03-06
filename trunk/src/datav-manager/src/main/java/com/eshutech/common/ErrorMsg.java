/**
 * Copyright (c) 2016. Drore Co, Ltd. All rights reserved.
 * Filename: ErrorMsg
 * Creator:  wanggao
 * Create-Date: 上午12:52
 **/
package com.eshutech.common;

/**
 *
 * @author: Kim
 * @date: 16/7/25
 * @time: 上午12:52
 *
 */
public class ErrorMsg extends Object {
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String code = "200";
    private String msg = "成功";
}
