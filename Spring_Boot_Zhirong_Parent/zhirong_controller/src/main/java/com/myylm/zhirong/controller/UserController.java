package com.myylm.zhirong.controller;

import com.myylm.commons.aop.LoggerManage;
import com.myylm.zhirong.model.UserModel;
import com.myylm.zhirong.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author hmmzhtx
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    public  static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/test",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    @LoggerManage(logDescription = "测试日志")
    public UserModel test( ){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return userService.findUserModelByName("命名");
    }





}
