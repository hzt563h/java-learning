package com.hzt.demo.strategy;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName AttackJY.java
 * @createTime 2021年03月29日 20:22:00
 */
public class AttackJYSG implements IAttackBehavior {
    @Override
    public void attack() {
        System.out.println("九阳神功");
    }
}
