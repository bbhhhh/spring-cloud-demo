package com.example.springclouddemo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/11/27 16:40
 * @Description: TODO
 */
@RestController
public class ConsumerController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ConsumerController.class);

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }
}
