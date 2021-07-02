package com.hzt.demo.jvm;


import org.openjdk.jol.info.ClassLayout;

public class JOLDemo {
    private static Object  o = new Object();
    public static void main(String[] args) throws InterruptedException {
        //Thread.sleep(5000);
        /**
         * Syn锁升级之后，jdk1.8版本的一个底层默认设置4s之后偏向锁开启。
         * 也就是说在4s内是没有开启偏向锁的，加了锁就直接升级为轻量级锁了。
         */
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("------------------加锁后的变化--------------------");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
