package com.example.springclouddemo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/11/27 16:35
 * @Description: TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
