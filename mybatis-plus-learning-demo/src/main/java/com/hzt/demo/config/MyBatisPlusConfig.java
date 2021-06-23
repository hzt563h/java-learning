package com.hzt.demo.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName MyBatisPlusConfig.java
 * @Description TODO
 * @createTime 2021年03月22日 19:48:00
 */
@Configuration
@MapperScan(basePackages = "com.hzt.demo.mapper")
public class MyBatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
