package com.hzt.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName Test.java
 * @createTime 2021年05月06日 14:04:00
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "123";
    }
}
