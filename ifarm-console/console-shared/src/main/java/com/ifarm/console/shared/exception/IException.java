package com.ifarm.console.shared.exception;

/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 异常接口
 */
public interface IException {
    
    String getErrorCode();
    
    String getNativeMessage();
    
    void setErrorArguments(Object... objects);
    
    Object[] getErrorArguments();
    
}
