package com.hzt.demo.singleton;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName Singleton.java
 * @Description TODO
 * @createTime 2021年02月09日 15:45:00
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
