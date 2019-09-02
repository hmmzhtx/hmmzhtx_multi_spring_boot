package com.myylm.commons.ExceptionHandler;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalDefultExceptionHandler {
    
    /**
     * 处理参数异常，一般用于校验body参数
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleValidationBodyException(MethodArgumentNotValidException e) {
        for (ObjectError s : e.getBindingResult().getAllErrors()) {
            return new ErrorMessage("Invalid_Request_Parameter", s.getObjectName() + ": " + s.getDefaultMessage());
        }
        return new ErrorMessage("Invalid_Request_Parameter", "未知参数错误");
    }


    /**
     * 主动throw的异常
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public ErrorMessage handleUnProccessableServiceException(ServiceException e, HttpServletResponse response) {
        response.setStatus(e.getStatusCode().value());
        return new ErrorMessage(e.getErrorCode(), e.getMessage());
    }
    
}
