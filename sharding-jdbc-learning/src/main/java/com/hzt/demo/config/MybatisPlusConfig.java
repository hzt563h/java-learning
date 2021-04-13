package com.hzt.demo.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName MybatisPlusConfig.java
 */
@Configuration
@MapperScan({"com.hzt.demo.mapper"})
public class MybatisPlusConfig {

}
