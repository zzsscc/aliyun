package com.eshutech.biz.cache.exception;

/**
 * @Author: Lajiao
 * @Date: 13-12-04
 * @Time: 上午9:47
 * @Description: REDIS异常返回
 */
public class RedisException extends Exception {
    private static final long serialVersionUID = -238091758285157331L;

    private String code;
    private String msg;

    public RedisException() {
        super();
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(Throwable cause) {
        super(cause);
    }

    public RedisException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.code = errCode;
        this.msg = errMsg;
    }

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
}
