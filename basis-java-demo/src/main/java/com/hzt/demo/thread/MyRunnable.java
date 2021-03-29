package com.hzt.demo.thread;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName MyThread.java
 * @Description TODO 实现 Runnable 接口
 * @createTime 2021年02月02日 20:30:00
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("我是另一个线程");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
