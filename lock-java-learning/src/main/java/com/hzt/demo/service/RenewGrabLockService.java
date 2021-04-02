package com.hzt.demo.service;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName RenewGrabLockService.java
 * @createTime 2021年04月02日 15:39:00
 */
public interface RenewGrabLockService {
    /**
     * 续约
     * @param key
     * @param value
     * @param time
     */
    void renewLock(String key , String value , int time);

}
