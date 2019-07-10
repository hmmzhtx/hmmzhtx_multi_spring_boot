package com.myylm.Controller;

import com.myylm.commons.aop.LoggerManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;


    /**
     * 返回其 json数据
     * @return
     */
    @RequestMapping(value = "/helloSay", method = RequestMethod.GET)
    @ResponseBody  //此注解是设定返回数据 还是 到页面模版
    @LoggerManage(logDescription = "client_Hello")
    public String HelloWordController(){
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return "Hello World";
    }


}
