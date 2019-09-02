package com.myylm.controller;

import com.myylm.commons.aop.LogAop.LoggerManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ccy")
public class ConcurrencyController {

    public  static Logger logger = LoggerFactory.getLogger(ConcurrencyController.class);

    /**
     * 返回其 json数据
     * @return
     */
    @RequestMapping(value = "/ccy_test", method = RequestMethod.GET)
    @ResponseBody
    @LoggerManage(logDescription = "并发_测试")
    public String CcyController(){
        return "并发搭建测试";
    }



}
