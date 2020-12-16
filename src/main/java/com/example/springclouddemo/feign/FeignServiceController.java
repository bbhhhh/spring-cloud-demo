package com.example.springclouddemo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springclouddemo.hello.User;


/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/4 15:08
 * @Description: TODO
 */
@RestController
@RequestMapping("/feign-service")
public class FeignServiceController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(FeignServiceController.class);

    @Autowired
    private HelloService feignHelloService;

    @GetMapping("/hello")
    public String hello() {
        return feignHelloService.hello();
    }

    @GetMapping("/hello2")
    public String hello(@RequestParam String name) {
        return feignHelloService.hello(name);
    }

    @GetMapping("/hello3")
    public String hello(@RequestHeader(required = false) String name, @RequestHeader Integer age) {
        return feignHelloService.hello(name, age);
    }

    @PostMapping("/hello4")
    public String hello(@RequestBody User user) {
        return feignHelloService.hello(user);
    }
}
