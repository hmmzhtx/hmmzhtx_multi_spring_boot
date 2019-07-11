package com.myylm.service;

import com.myylm.service.fallback.HelloClientServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client",fallback = HelloClientServiceFallback.class)
public interface HelloClientService {

    @GetMapping("/helloSay")
    String helloSay();


    

}
