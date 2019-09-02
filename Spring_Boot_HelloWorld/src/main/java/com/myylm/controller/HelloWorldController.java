package com.myylm.controller;

import com.myylm.commons.aop.LogAop.LoggerManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hmmzhtx
 * @date 2018/3/23
 */


/**
 * @RestController 等同于 @Controller 和 @ResponseBody 组合（此设定返回数据格式）
 * 若是同个类中返回既有数据格式，也有模版格式，则在类上注解仅使用：@Controller
 *  返回数据时，方法上使用：@RequestMapping，@ResponseBody
 *  返回模版时，方法上使用：@RequestMapping
 *
 */


@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    public  static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    /**
     * 返回其 json数据
     * @return
     */
    @RequestMapping(value = "/helloSay", method = RequestMethod.GET)
    @ResponseBody  //此注解是设定返回数据 还是 到页面模版
    @LoggerManage(logDescription = "日志Hello")
    public String HelloWordController(){
         return "Hello World";
    }






}
