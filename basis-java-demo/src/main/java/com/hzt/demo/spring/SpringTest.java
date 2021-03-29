package com.hzt.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName SpringTest.java
 * @Description TODO
 * @createTime 2021年02月02日 20:41:00
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean(Persion.class));
    }
}
