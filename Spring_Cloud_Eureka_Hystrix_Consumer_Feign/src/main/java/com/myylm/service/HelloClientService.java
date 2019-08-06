package com.myylm.service;

import com.myylm.service.fallback.HelloClientServiceHystrixFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-client",fallback = HelloClientServiceHystrixFallback.class)
public interface HelloClientService {

    @GetMapping( value = "/helloSay")
    String helloSay( @RequestParam("v") String v);

}
