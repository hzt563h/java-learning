package com.hzt.demo.service;

import com.hzt.demo.model.User;

import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserService.java
 * @createTime 2021年04月12日 16:15:00
 */
public interface UserService {
    List<User> getUserList();

    boolean insertUser(User user);
}
