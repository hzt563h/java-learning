package com.hzt.demo.thread;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName myThread.java
 * @Description TODO
 * @createTime 2021年02月03日 09:11:00
 */
public class myThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承 Thread 类重写run方法");
    }

    public static void main(String[] args) {
        myThread myThread = new myThread();
        myThread.start();
    }
}
