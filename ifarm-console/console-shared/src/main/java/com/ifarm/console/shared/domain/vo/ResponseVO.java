package com.ifarm.console.shared.domain.vo;

import java.io.Serializable;

/**
 *
 */
public class ResponseVO<T> implements Serializable {
    private Boolean success;
    private String code;
    private String message;
    private String token;
    private T result;

    public ResponseVO() {
        this.success = true;
    }

    public ResponseVO(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
