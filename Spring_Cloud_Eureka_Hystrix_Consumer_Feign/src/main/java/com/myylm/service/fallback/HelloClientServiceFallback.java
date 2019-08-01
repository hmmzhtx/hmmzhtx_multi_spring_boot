package com.myylm.service.fallback;

import com.myylm.service.HelloClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HelloClientServiceFallback  implements HelloClientService {


    @Override
    public String helloSay(String v) {
        return "反应过慢，进行服务降级";
    }
}
