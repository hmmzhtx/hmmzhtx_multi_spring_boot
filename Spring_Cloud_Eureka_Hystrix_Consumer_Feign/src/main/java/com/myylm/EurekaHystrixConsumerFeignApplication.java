package com.myylm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 带熔断功能的消费者
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaHystrixConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixConsumerFeignApplication.class, args);
    }



    
}
