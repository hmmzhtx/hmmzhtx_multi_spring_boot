package com.myylm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hmmzhtx
 */
@Controller
public class ThymeleafController {


    protected static Logger logger= LoggerFactory.getLogger(ThymeleafController.class);

    /**
     * Thymeleaf
     * @param model
     * @return
     */
    @RequestMapping("/toThy")
    public String index(Model model){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");

        model.addAttribute("name", "11111");
        return "thy";
    }


}
