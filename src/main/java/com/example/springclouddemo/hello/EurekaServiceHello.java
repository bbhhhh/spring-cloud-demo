package com.example.springclouddemo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/11/27 14:38
 * @Description: TODO
 */


@SpringCloudApplication
public class EurekaServiceHello {
    private static final Logger logger = LoggerFactory.getLogger(EurekaServiceHello.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceHello.class, args);
    }
}
