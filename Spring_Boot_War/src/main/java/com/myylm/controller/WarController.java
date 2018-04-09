package com.myylm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hmmzhtx
 */
@RestController
public class WarController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
