package com.ifarm.docker.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hairen.long
 * @date 2020/8/30
 */
@RestController
public class HelloController {

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "hello " + name;
    }
}
