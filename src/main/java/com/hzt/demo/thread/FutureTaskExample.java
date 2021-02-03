package com.hzt.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName FutureTaskExample.java
 * @Description TODO
 * @createTime 2021年02月03日 15:14:00
 */
public class FutureTaskExample {
    /**
     * 在介绍 Callable 时我们知道它可以有返回值，返回值通过 Future<V> 进行封装。FutureTask 实现了 RunnableFuture 接口，
     * 该接口继承自 Runnable 和 Future<V> 接口，这使得 FutureTask 既可以当做一个任务执行，也可以有返回值。
     *
     * public class FutureTask<V> implements RunnableFuture<V>
     * public interface RunnableFuture<V> extends Runnable, Future<V>
     * FutureTask 可用于异步获取执行结果或取消执行任务的场景。当一个计算任务需要执行很长时间，
     * 那么就可以用 FutureTask 来封装这个任务，主线程在完成自己的任务之后再去获取结果。
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
