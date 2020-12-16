package com.example.springclouddemo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/8 15:53
 * @Description: TODO
 */

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ZuulGatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
