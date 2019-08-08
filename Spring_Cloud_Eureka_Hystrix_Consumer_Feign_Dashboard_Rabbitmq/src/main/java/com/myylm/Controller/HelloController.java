package com.myylm.Controller;

import com.myylm.commons.aop.LoggerManage;
import com.myylm.service.HelloClientMoreService;
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

    @Autowired
    HelloClientMoreService helloClientMoreService;


    @GetMapping("/hystrix_consumer_Hello_dashboard")
    @LoggerManage(logDescription = "hystrix_consumer_Hello_dashboard")
    public String helloSay() {
        return helloClientService.helloSay("带熔断的消费者,加入了面板监控");
    }


    @GetMapping("/hystrix_consumer_Hello_dashboard_more")
    @LoggerManage(logDescription = "hystrix_consumer_Hello_dashboard_more")
    public String helloSayMore() {
        return helloClientMoreService.helloSay("带熔断的消费者,加入了面板监控");
    }


}
