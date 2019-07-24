package com.myylm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 微服务，按照不同的业务，分块、分类 编写不同的对应服务
 *
 * 当大流量出现时，还可以横向扩展此服务，以达到分流的目的
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
