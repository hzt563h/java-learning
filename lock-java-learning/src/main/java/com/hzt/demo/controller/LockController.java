package com.hzt.demo.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName LockController.java
 * @createTime 2021年04月02日 11:26:00
 */
@RestController
public class LockController {
    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/test")
    public String test(){
        RLock rLock = redissonClient.getLock("myLock");
        try {
            boolean res = rLock.tryLock(0, TimeUnit.SECONDS);
            if(res) {
                System.out.println("getLock Success");
                Thread.sleep(50);
            } else {
                System.out.println("getLock failure");
            }
            rLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "123";
    }

}
