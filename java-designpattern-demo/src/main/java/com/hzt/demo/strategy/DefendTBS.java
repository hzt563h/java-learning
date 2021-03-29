package com.hzt.demo.strategy;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName DefendTBS.java
 * @createTime 2021年03月29日 20:23:00
 */
public class DefendTBS implements IDefendBehavior {
    @Override
    public void defend() {
        System.out.println("铁布衫");
    }
}
