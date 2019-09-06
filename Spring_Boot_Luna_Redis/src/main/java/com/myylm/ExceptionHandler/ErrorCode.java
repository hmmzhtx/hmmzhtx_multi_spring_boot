package com.myylm.ExceptionHandler;

public enum  ErrorCode {

    Error(10000, "服务异常"),
    RateLimitError(10001, "已经到设置限流次数");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }



}
