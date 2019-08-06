package com.myylm.Controller;

import com.myylm.commons.aop.LoggerManage;
import com.myylm.service.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 带熔断的消费者
 */
@RestController
public class HelloController {

    @Autowired
    HelloClientService helloClientService;


    @GetMapping("/hystrix_consumer_Hello")
    @LoggerManage(logDescription = "hystrix_consumer_Hello")
    public String helloSay() {
        return helloClientService.helloSay("带熔断的消费者");
    }

}
