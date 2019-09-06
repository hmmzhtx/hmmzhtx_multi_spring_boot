package com.myylm.ExceptionHandler;

import java.io.Serializable;
import java.util.Objects;

public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 8065583911104112360L;
    private int errorCode;
    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMessage);
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
