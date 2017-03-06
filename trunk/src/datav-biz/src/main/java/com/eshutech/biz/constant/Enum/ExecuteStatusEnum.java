package com.eshutech.biz.constant.Enum;

/**
 * @Author:Lajiao
 * @Date:2014年7月14日
 * @Time:下午3:49:44
 * @Description:数据状态定义
 */
public enum ExecuteStatusEnum {
    INIT(0, "初始化"),
    WAIT(1, "等待处理"),
    SUCC(2, "处理成功"),
    FAIL(3, "处理失败"),
    HOLD(9, "保留");

    private Integer code;
    private String name;

    ExecuteStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String code) {
        if (code == null) {
            return "";
        }
        for (ExecuteStatusEnum re : ExecuteStatusEnum.values()) {
            if (re.getCode().equals(code)) {
                return re.getName();
            }
        }
        return "";
    }

    public static Integer getCode(String name) {
        if (name == null) {
            return null;
        }
        for (ExecuteStatusEnum re : ExecuteStatusEnum.values()) {
            if (name.equals(re.getName())) {
                return re.getCode();
            }
        }
        return null;
    }
}
