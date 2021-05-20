package com.hzt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName JVMApplication.java
 * @createTime 2021年05月06日 13:59:00
 */
@EnableAsync
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JVMApplication {
    public static void main(String[] args) {
        SpringApplication.run(JVMApplication.class,args);
    }
}
