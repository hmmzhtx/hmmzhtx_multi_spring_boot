package com.myylm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;




@EnableHystrix   //@EnableHystrix  如果要实现面板，必须加入此注解，即使fegin已经通过属性
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaHystrixConsumerFeignDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixConsumerFeignDashboardApplication.class, args);
    }

}
