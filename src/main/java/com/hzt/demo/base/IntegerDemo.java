package com.hzt.demo.base;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName IntegerDemo.java
 * @Description TODO
 * @createTime 2021年02月03日 16:47:00
 */
public class IntegerDemo {
    /**
     * 在 Java 8 中，Integer 缓存池的大小默认为 -128~127。
     * 在 jdk 1.8 所有的数值类缓冲池中，Integer 的缓冲池 IntegerCache 很特殊
     * 这个缓冲池的下界是 - 128，上界默认是 127，但是这个上界是可调的，
     * 在启动 jvm 的时候，通过 -XX:AutoBoxCacheMax=<size> 来指定这个缓冲池的大小，
     * 该选项在 JVM 初始化的时候会设定一个名为 java.lang.IntegerCache.high 系统属性
     * 然后 IntegerCache 初始化的时候就会读取该系统属性来决定上界。
     * @param args
     */
    public static void main(String[] args) {
        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true
        Integer a=5;
        Integer b=5;
        System.out.println(a == b);//true
        Integer c=200;
        Integer d=200;
        System.out.println(c == d);//false
    }
}
