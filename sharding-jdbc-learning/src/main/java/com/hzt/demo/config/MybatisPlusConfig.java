package com.hzt.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName MybatisPlusConfig.java
 */
@Configuration
@MapperScan({"com.hzt.demo"})
public class MybatisPlusConfig {
}
