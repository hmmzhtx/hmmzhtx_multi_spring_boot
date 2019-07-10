package com.myylm.Controller;

import com.myylm.commons.aop.LoggerManage;
import com.myylm.impl.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    HelloClientService helloClientService;

    @GetMapping("/consumer_Hello")
    @LoggerManage(logDescription = "consumer_Hello")
    public String helloSay() {
        return helloClientService.helloSay();
    }

}
