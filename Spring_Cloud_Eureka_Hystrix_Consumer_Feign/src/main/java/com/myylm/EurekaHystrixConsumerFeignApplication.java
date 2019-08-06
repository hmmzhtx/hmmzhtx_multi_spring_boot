package com.myylm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 带熔断功能的消费者
 */
//@EnableHystrix  //Feign自带熔断，不需要此注解，开启熔断在配置文件中:feign.hystrix.enabled=true（在应用主类中使用@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用）
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaHystrixConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixConsumerFeignApplication.class, args);
    }

}
