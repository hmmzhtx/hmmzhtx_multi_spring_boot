package com.myylm.Controller;

import com.myylm.commons.aop.LogAop.LoggerManage;
import com.myylm.service.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 单纯的消费者
 */
@RestController
public class HelloController {

    @Autowired
    HelloClientService helloClientService;

    @GetMapping("/consumer_Hello")
    @LoggerManage(logDescription = "consumer_Hello")
    public String helloSay() {
        return helloClientService.helloSay("单纯的消费者");
    }

}
