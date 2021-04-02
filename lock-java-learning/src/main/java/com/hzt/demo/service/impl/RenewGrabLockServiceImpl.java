package com.hzt.demo.service.impl;

import com.hzt.demo.service.RenewGrabLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName RenewGrabLockServiceImpl.java
 * @createTime 2021年04月02日 15:40:00
 */
@Service
public class RenewGrabLockServiceImpl implements RenewGrabLockService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Async
    public void renewLock(String key, String value, int time) {
        String v = (String) redisTemplate.opsForValue().get(key);
        if (value.equals(v)){
            int sleepTime = time / 3;
            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.expire(key,time,TimeUnit.SECONDS);
            renewLock(key,value,time);
        }

    }

}
