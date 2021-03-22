package com.hzt.demo.model;

import lombok.Data;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2021年03月22日 19:55:00
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
