package com.hzt.demo.jvm;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName Leak.java
 * @createTime 2021年05月06日 10:13:00
 */
public class GCUseTest {
    static final Integer _1MB = 1024 * 1024;
    public static void main(String[] args) {
        byte [] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 *_1MB];
        allocation2 = new byte[2 *_1MB];
        allocation3 = new byte[2 *_1MB];
        allocation4 = new byte[4 *_1MB];
    }
}
