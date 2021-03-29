package com.hzt.demo.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName ThreadPoolExecutorExample.java
 * @Description TODO
 * @createTime 2021年02月22日 14:07:00
 */
public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 2, 1000,
                TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池的使用");
            }
        });
    }
}
