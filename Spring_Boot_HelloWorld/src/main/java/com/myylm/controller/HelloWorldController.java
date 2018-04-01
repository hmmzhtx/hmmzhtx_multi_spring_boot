package com.myylm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hmmzhtx
 * @date 2018/3/23
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String HelloWordController(){
        return "Hello world";
    }



}
