package com.hzt.demo.strategy;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName DisplayA.java
 * @createTime 2021年03月29日 20:30:00
 */
public class DisplayYZ implements IDisplayBehavior {

    @Override
    public void display() {
        System.out.println("样子1");
    }
}
