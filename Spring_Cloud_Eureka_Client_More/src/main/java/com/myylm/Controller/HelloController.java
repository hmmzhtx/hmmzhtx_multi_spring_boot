package com.myylm.Controller;

import com.myylm.commons.aop.LogAop.LoggerManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;



    /**
     * 返回其 json数据
     * @return
     */
    @RequestMapping(value = "/helloSay_more", method = RequestMethod.GET)
    @ResponseBody  //此注解是设定返回数据 还是 到页面模版
    @LoggerManage(logDescription = "helloSay_more")
    public String HelloWordController(@RequestParam(value = "v") String v){
        return "Hello World More" + ">>" + v;
    }


}
