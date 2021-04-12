package com.hzt.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2021年03月22日 19:55:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id")
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
