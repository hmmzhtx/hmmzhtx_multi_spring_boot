package com.myylm.service.fallback;

import com.myylm.service.HelloClientMoreService;
import org.springframework.stereotype.Component;

@Component
public class HelloClientMoreServiceHystrixFallback implements HelloClientMoreService {


    @Override
    public String helloSay(String v) {
        return "反应过慢，进行服务降级";
    }


}
