package com.example.springclouddemo.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/4 14:24
 * @Description: TODO
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerByFeignServiceApplication {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConsumerByFeignServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumerByFeignServiceApplication.class, args);
    }

}
