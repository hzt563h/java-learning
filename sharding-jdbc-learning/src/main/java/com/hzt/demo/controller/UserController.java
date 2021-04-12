package com.hzt.demo.controller;

import com.hzt.demo.model.User;
import com.hzt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserController.java
 * @createTime 2021年04月12日 16:14:00
 */
@RestController
public class UserController {


    @GetMapping("/select")
    public List<User> select() {
        return null;
    }


}
