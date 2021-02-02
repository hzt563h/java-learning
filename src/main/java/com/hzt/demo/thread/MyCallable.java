package com.hzt.demo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName MyCallable.java
 * @Description TODO
 * @createTime 2021年02月02日 20:54:00
 */
public class MyCallable implements Callable<String> {
    public String call() throws Exception {
        return "你好";
    }

    public static void main(String[] args) {
        MyCallable mc = new MyCallable();
        FutureTask<String> ft = new FutureTask<String>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
