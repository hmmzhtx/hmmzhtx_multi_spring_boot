package com.myylm.service;

        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface HelloClientService {

    @GetMapping("/helloSay")
    String helloSay(@RequestParam("v")String v);

}
