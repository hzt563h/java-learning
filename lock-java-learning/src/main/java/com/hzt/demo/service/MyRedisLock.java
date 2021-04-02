package com.hzt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName RedisServiceImpl.java
 * @createTime 2021年04月02日 15:36:00
 */
@Service
public class MyRedisLock implements Lock {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RenewGrabLockService renewGrabLockService;

    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    @Override
    public void lock() {
        String uuid = UUID.randomUUID().toString();
        stringLocal.set(uuid);
        while (!redisTemplate.opsForValue().setIfAbsent("mylock", uuid, 30L, TimeUnit.SECONDS)){
            System.out.println("加锁失败");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        renewGrabLockService.renewLock("mylock",uuid,30);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        String script="if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                "    return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "    return 0\n" +
                "end";
        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>(script, Long.class);
        redisTemplate.execute(longDefaultRedisScript, Arrays.asList("mylock"),stringLocal.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
