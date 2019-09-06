package com.myylm.ExceptionHandler;


public class ServiceException extends Throwable {
    private static final long serialVersionUID = 8109469326798389194L;


    private int  errorCode;


    public ServiceException(String message) {
        super(message);
        this.errorCode = ErrorCode.RateLimitError.getCode();
    }

    public ServiceException() {
        super(ErrorCode.RateLimitError.getMessage());
        this.errorCode = ErrorCode.RateLimitError.getCode();
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
