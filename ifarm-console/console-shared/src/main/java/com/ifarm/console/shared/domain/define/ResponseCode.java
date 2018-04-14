package com.ifarm.console.shared.domain.define;

/**
 *
 */
public enum ResponseCode {
    SUCCESS("100000", "成功！"),
    FAILURE("100001", "系统异常！"),
    LOGIN_SUCCESS("200000", "登录成功！"),
    UN_LOGIN("200001", "未登录！"),
    LOGIN_FAIL("200002","登录失败！"),
    UNAUTHORIZED("200003", "未授权！"),
    LOGOUT("200004","退出"),
    ;




    private String code;
    private String message;

    private ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
