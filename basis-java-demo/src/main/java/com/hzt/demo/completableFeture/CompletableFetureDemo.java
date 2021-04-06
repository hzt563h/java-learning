package com.hzt.demo.completableFeture;

import java.util.concurrent.*;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName CompletableFetureDemo.java
 * @createTime 2021年04月06日 09:41:00
 */
public class CompletableFetureDemo {
    // 示例代码线程池
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //无返回值的异步操作
        CompletableFuture.runAsync(()->{
            System.out.println("无返回值的异步操作");
        },executor);

        //有返回值的异步操作
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值的异步操作");
            return 1;
        }, executor);
        System.out.println(supplyAsync.get());

        //计算完成时的回调whenComplete
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10 / 0;
            return n;
        }, executor).whenComplete((result,excption) -> {
            System.out.println("运行结果：" + result + "异常：" + excption);
        }).exceptionally(throwable -> {
            // 出现异常 exceptionally感知并处理异常，返回最终结果
            return 10;
        });
        System.out.println("异常后的最终返回"+future.get());


        //handleAsync 方法
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10 / 0;
            return n;
        }, executor).handleAsync((res, exception) -> {
            if (res != null) {
                // 如果上一个任务没出现异常，修改返回结果
                return res * 10;
            }
            if (exception != null) {
                // 上一个任务出现了异常
                return 0;
            }
            return 0;
        });


        /**
         * 线程串行化方法
         * 方法介绍
         * **thenApply方法:**当一个线程依赖另一个 线程时，获取上一个任务返回的结果，返回当前任务的返回值。
         *
         * **thenAccept方法:**消费处理结果。接收任务的处理结果，并消费处理，无返回结果。
         *
         * **thenRun方法:**只要上面的任务执行完成，就开始执行thenRun,只是处理完任务后，执行thenRun的后续操作
         */

        // thenRunAsync 不能获取上一步执行结果
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10 / 0;
            return n;
        }, executor).thenRunAsync(() -> {
            System.out.println("线程2运行了！");
        }, executor);

        // thenAcceptAsync可以获取上一个任务执行的结果，但是无法对其进行修改
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10;
            return n;
        }, executor).thenAcceptAsync((res) -> {
            // 如果上一个任务产生异常或者执行失败，则不执行该任务
            System.out.println("上一个任务获取的结果：" + res);
        }, executor);

        //thenApplyAsync 可以获取上一个任务返回的结果，并对其进行修改再返回
        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10;
            return n;
        }, executor).thenApplyAsync((res) -> {
            return res * 2;
        }, executor);

        Integer result = future.get();

        System.out.println("最终返回结果：" + result);

        //applyToEitherAsync：阻塞等待，只要有一个任务完成了，就执行该任务
        CompletableFuture<Integer> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 5;
            // 模拟这个任务比较慢完成，让future6先完成，测试applyToEitherAsync 只要有一个任务完成就执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return n;
        }, executor);

        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程号 -> " + Thread.currentThread().getId());
            int n = 10;
            return n;
        }, executor);

        future5.applyToEitherAsync(future6, res -> {
            System.out.println(res);
            return res + 1;
        }, executor);

        //组合任务，所有的完成
        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1当前线程号 -> " + Thread.currentThread().getId());
            int n = 5;
            return n;
        }, executor);

        CompletableFuture<Integer> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2当前线程号 -> " + Thread.currentThread().getId());
            int n = 10;
            return n;
        }, executor);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(future7, future8);
        // 阻塞等待所有的任务执行完成
        allOf.get();

        Integer result1 = future7.get();
        Integer result2 = future8.get();


    }
}
