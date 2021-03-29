package com.hzt.demo.thread;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName TempDemo.java
 * @Description TODO
 * @createTime 2021年02月18日 10:32:00
 */
public class TempDemo {
    /**
     * 开启两个线程A、B，打印1到10，线程A打印奇数（1、3、5、7、9），线程B打印偶数（2、4、6、8、10）。
     * @param args
     */
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                if (i % 2 != 0){
                    System.out.println(i);
                }
            }
        }, "线程A").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                if (i % 2 == 0){
                    System.out.println(i);
                }
            }
        }, "线程B").start();
    }
}
