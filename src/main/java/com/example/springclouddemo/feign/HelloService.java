package com.example.springclouddemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springclouddemo.hello.User;


/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/4 14:30
 * @Description: TODO
 */
@FeignClient(value = "hello-service")
public interface HelloService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/hello2")
    String hello(@RequestParam("name2") String name);

    @GetMapping("/hello3")
    String hello(@RequestHeader(value = "name3") String name, @RequestHeader(value = "age") Integer age);

    @PostMapping("/hello4")
    String hello(@RequestBody User user);
}
