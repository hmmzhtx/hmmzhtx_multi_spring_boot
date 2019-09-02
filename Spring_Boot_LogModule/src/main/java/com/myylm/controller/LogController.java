package com.myylm.controller;

import com.myylm.commons.aop.LogAop.LoggerManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hmmzhtx
 */
@Controller
public class LogController {

    public  static Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "/logInfo")
    @ResponseBody
    @LoggerManage(logDescription = "日志测试")
    public String logDo(){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "打印！！";
    }
}
