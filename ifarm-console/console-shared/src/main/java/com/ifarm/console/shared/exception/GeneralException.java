package com.ifarm.console.shared.exception;

/**
 * @author longhairen
 * @create 2017/6/6 0006 下午 7:24
 * 所有的由框架各个层互相调用产生的解析、转换、调用接口错误导致的错误统称交互异常
 * 交互异常与应用异常的最明显区别是：应用异常是业务逻辑错误，需要业务方法进行Try..Catch
 */

	
public abstract class GeneralException extends RuntimeException implements IException {
    
    private static final long serialVersionUID = 5374060474539004523L;
    protected String errCode;
    private String nativeMsg;
    private Object[] arguments;
    
    public String getErrorCode() {
        return errCode;
    }
    
    @Override
    public void setErrorArguments(Object... args) {
        this.arguments = args;
    }
    
    @Override
    public String getNativeMessage() {
        return this.nativeMsg;
    }
    
    @Override
    public Object[] getErrorArguments() {
        return this.arguments;
    }
    
    public GeneralException() {
        super();
    }
    
    public GeneralException(String msg) {
        super(msg);
    }
    
    public GeneralException(Throwable cause) {
        super(cause);
    }
    
    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GeneralException(Throwable cause, String nativeMsg) {
        super(cause);
        this.nativeMsg = nativeMsg;
    }
    
    public GeneralException(String msg, String nativeMsg) {
        super(msg);
        this.nativeMsg = nativeMsg;
    }
    
    public GeneralException(String message, Throwable cause, String nativeMsg) {
        super(message, cause);
        this.nativeMsg = nativeMsg;
    }
    
    public GeneralException(String errCode, String message, Throwable cause, Object...arguments) {
    	super(message, cause);
    	this.errCode = errCode;
    	this.arguments = arguments;
    }
    
    public GeneralException(String errCode, String message, Throwable cause, String nativeMsg, Object...arguments) {
    	super(message, cause);
    	this.errCode = errCode;
    	this.arguments = arguments;
    	this.nativeMsg = nativeMsg;
    }
    
}
