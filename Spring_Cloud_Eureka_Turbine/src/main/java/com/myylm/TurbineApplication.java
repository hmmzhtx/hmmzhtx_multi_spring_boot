package com.myylm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * 启动：
 *  Spring_Cloud_Eureka_Server
 *  Spring_Cloud_Eureka_Client
 *  Spring_Cloud_Eureka_Client_More
 *  Spring_Cloud_Eureka_Hystrix_Consumer_Feign_Dashboard
 *  Spring_Cloud_Eureka_Hystrix_Dashboard
 *  Spring_Cloud_Eureka_Turbine
 */
@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }

}
