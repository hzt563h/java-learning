package com.hzt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName Main.java
 * @createTime 2021年04月02日 11:20:00
 */
@EnableAsync
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
