package com.hzt.demo.controller;

import com.hzt.demo.model.User;
import com.hzt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserController.java
 * @createTime 2021年06月22日 17:53:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getList")
    public List<User> getList() {
        return userService.getList();
    }
}
