package com.ifarm.console.shared.exception;

import java.io.Serializable;

/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 业务异常基类
 */

public  class BusinessException extends RuntimeException implements
        Serializable, IException {

	private static final long serialVersionUID = 1937263904748419090L;

	protected String errCode;
	private String natvieMsg;
	private Object[] arguments;

	public BusinessException() {
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BusinessException(String code, String msg) {
		super(msg);
		this.errCode = code;
	}

	public BusinessException(String code, String msg, Throwable cause) {
		super(msg, cause);
		this.errCode = code;
	}

	public BusinessException(String code, String msg, String natvieMsg) {
		super(msg);
		this.errCode = code;
		this.natvieMsg = natvieMsg;
	}

	public BusinessException(String code, String msg, String natvieMsg,
                             Throwable cause) {
		super(msg, cause);
		this.errCode = code;
		this.natvieMsg = natvieMsg;
	}

	public BusinessException(String code, Object... args) {
		this.errCode = code;
		this.arguments = args;
	}

	public BusinessException(String code, String msg, Object... args) {
		super(msg);
		this.errCode = code;
		this.arguments = args;
	}

	public void setErrorArguments(Object... args) {
		this.arguments = args;
	}

	public Object[] getErrorArguments() {
		return this.arguments;
	}

	public String getErrorCode() {
		return this.errCode;
	}

	public String getNativeMessage() {
		return this.natvieMsg;
	}
}
