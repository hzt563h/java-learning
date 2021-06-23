package com.hzt.demo.service.impl;

import com.hzt.demo.mapper.UserMapper;
import com.hzt.demo.model.User;
import com.hzt.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @createTime 2021年06月22日 17:56:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getList() {
        return userMapper.getList();
    }
}
