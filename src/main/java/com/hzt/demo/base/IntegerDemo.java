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
