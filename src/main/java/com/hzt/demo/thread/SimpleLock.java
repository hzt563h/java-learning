package com.hzt.demo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName SimpleLock.java
 * @Description TODO
 * 建立三个线程A、B、C，A线程打印10次字母A，
 * B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 * @createTime 2021年02月18日 13:56:00
 */
public class SimpleLock {
    private static Lock lock=new ReentrantLock();
    private static int state=1;
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state == 1){
                        System.out.print("A");
                        state = 2;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state == 2){
                        System.out.print("B");
                        state = 3;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    while (state == 3){
                        System.out.print("C");
                        state = 1;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        },"C").start();
    }

}
