package com.myylm.ExceptionHandler;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalDefultExceptionHandler {

    /**
     * 主动throw的异常
     * @param e
     * @param req
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public ErrorMessage handleUnProccessableServiceException(ServiceException e, HttpServletRequest req) {
        return new ErrorMessage(e.getErrorCode(), e.getMessage());
    }


    
}
