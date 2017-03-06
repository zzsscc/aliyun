package com.eshutech.biz.exception;

/**
 * 数据统计异常
 *
 * @version 1.0.0
 * @lajiao
 * @Aug 1, 2013 5:42:06 PM
 */
public class StatisticsException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String code;
    private String msg;

    public StatisticsException() {
        super();
    }

    public StatisticsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatisticsException(String message) {
        super(message);
    }

    public StatisticsException(Throwable cause) {
        super(cause);
    }

    public StatisticsException(String errCode, String errMsg) {
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
