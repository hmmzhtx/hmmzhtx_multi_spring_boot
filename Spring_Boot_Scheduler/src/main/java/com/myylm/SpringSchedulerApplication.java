package com.myylm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author hmmzhtx
 */
@SpringBootApplication
@EnableScheduling
public class SpringSchedulerApplication {

    public static void main(String args[]){
        SpringApplication.run(SpringSchedulerApplication.class,args);
    }

}
