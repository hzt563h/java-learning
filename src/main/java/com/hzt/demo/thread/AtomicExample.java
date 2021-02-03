package com.hzt.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName AtomicExample.java
 * @Description TODO
 * @createTime 2021年02月03日 15:48:00
 */
public class AtomicExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add() {
        cnt.incrementAndGet();
    }

    public int get() {
        return cnt.get();
    }
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        AtomicExample example = new AtomicExample(); // 只修改这条语句
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
