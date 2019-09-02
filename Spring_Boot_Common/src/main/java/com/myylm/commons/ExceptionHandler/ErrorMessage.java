package com.myylm.commons.ExceptionHandler;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 8065583911104112360L;
    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage() {
        super();
    }
}
