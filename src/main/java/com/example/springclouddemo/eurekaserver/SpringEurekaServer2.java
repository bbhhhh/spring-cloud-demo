package com.example.springclouddemo.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/11/27 15:41
 * @Description: TODO
 */

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServer2 {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SpringEurekaServer2.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaServer2.class, args);
    }
}
