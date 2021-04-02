package com.hzt.demo.controller;

import com.hzt.demo.service.MyRedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName RedisLockController.java
 * @createTime 2021年04月02日 15:03:00
 */
@RestController
public class RedisLockController {

    @Autowired
    private Lock lock=new MyRedisLock();

    @GetMapping("/redisLock")
    public String redisLock() throws InterruptedException {

        try {
            lock.lock();
            System.out.println("执行业务");
            Thread.sleep(1000*35);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "123";
    }
}
