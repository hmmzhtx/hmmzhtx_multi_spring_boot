package com.myylm.service;

import com.myylm.service.fallback.HelloClientMoreServiceHystrixFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-client-more",fallback = HelloClientMoreServiceHystrixFallback.class)
public interface HelloClientMoreService {

    @GetMapping( value = "/helloSay_more")
    String helloSay(@RequestParam("v") String v);

}
