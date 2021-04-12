package com.hzt.demo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName Application.java
 */

@SpringBootApplication(exclude = {
        DruidDataSourceAutoConfigure.class,
        DataSourceAutoConfiguration.class,
})

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
