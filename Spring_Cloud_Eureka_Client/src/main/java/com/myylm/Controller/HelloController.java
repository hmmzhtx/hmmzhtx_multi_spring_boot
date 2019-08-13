package com.myylm.Controller;

import com.myylm.commons.aop.LoggerManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;


    public  static Logger logger = LoggerFactory.getLogger(HelloController.class);

    /**
     * 返回其 json数据
     * @return
     */
    @RequestMapping(value = "/helloSay", method = RequestMethod.GET)
    @ResponseBody  //此注解是设定返回数据 还是 到页面模版
    @LoggerManage(logDescription = "client_Hello")
    public String HelloWordController(@RequestParam(value = "v") String v){

        logger.info("client1....");

        return "Hello World" + ">>" + v;
    }


}
