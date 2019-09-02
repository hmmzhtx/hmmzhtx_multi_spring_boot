package com.myylm.controller;

import com.myylm.common.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @RateLimit(key = "test", time = 10, count = 10)
    @GetMapping("/test/limit")
    public String testLimit() {
        return "Hello,ok";
    }

    @RateLimit()
    @GetMapping("/test/limit/a")
    public String testLimitA() {
        return "Hello,ok";
    }

}
