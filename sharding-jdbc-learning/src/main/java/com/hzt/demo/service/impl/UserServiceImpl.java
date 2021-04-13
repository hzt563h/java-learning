package com.hzt.demo.service.impl;

import com.hzt.demo.mapper.UserMapper;
import com.hzt.demo.model.User;
import com.hzt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @createTime 2021年04月12日 16:16:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insert(user)>0;
    }
}
