package com.example.springclouddemo.hello;


import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/11/27 15:24
 * @Description: TODO
 */
@RestController
public class HelloServiceController {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HelloServiceController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/hello2")
    public String hello(@RequestParam("name2") String name) {
        return "hello2-" + name;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello(@RequestHeader(value = "name1", required = false, defaultValue = "user-name") String name, @RequestHeader Integer age) {
        return new User(name, age).toString();
    }

    @PostMapping(value = "/hello4", consumes = MediaType.APPLICATION_JSON)
    public String hello(@RequestBody User user) {
        return "hello4-" + user.toString();
    }

    @GetMapping(path = "/hello")
    public String hello() {
        String resp = "hello world";
        client.getServices().forEach(s -> logger.info("service name={}", s));
        if (client.getServices() != null && !client.getServices().isEmpty()) {
            ServiceInstance inst = client.getInstances(client.getServices().get(0)).get(0);
            logger.info("{}:{},{},{}", inst.getHost(), inst.getPort(), inst.getInstanceId(), inst.getServiceId());
            resp = "hello world from " + inst.getInstanceId();
        }
        return resp;
    }
}
