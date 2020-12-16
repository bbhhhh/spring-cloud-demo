package com.example.springclouddemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/14 16:38
 * @Description: TODO
 */

@SpringBootApplication
@EnableConfigServer
public class MySpringConfigServer {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MySpringConfigServer.class);

    public static void main(String[] args) {
        SpringApplication.run(MySpringConfigServer.class, args);
    }
}
