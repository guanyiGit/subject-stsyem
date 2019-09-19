package com.system.errorCode;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public enum ExamineeErrorCode {

    SUCCESS(0,"success"),
    FAILED(1,"failed"),

    COMMON_ACCOUNT_ERROR(1001, "账号错误"),
    COMMON_TOKEN_ERROR(1002, "token已过期"),
    COMMON_PARAM_EMPTY(1003, "必选参数为空"),
    COMMON_PARAM_ERROR(1004, "参数格式错误"),

    COMMON_EXIT(1005,"对象已存在"),

    SYSTEM_UNKNOWN_ERROR(-1, "系统繁忙，请稍后再试....");

    private Integer code;
    private String desc;

    ExamineeErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }

}
