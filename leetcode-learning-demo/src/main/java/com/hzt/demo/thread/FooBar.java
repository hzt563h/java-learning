package com.hzt.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 */
public class FooBar {
    private int n;
    private volatile int val=0;
    CyclicBarrier cb = new CyclicBarrier(2);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(val==1){
                // printFoo.run() outputs "foo". Do not change or remove this line.
            }
            printFoo.run();
            val=1;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            val=0;
        }
    }



}
