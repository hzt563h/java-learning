package com.hzt.demo.strategy;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName StrategyTest.java
 * @createTime 2021年03月29日 20:27:00
 */
public class StrategyTest {
    public static void main(String[] args) {
        Role roleA = new RoleA("A");

        roleA.setAttackBehavior(new AttackJYSG())//
                .setDefendBehavior(new DefendTBS())//
                .setDisplayBehavior(new DisplayYZ())//
                .setRunBehavior(new RunJCTQ());
        System.out.println(roleA.name + ":");
        roleA.run();
        roleA.attack();
        roleA.defend();
        roleA.display();

    }
}
