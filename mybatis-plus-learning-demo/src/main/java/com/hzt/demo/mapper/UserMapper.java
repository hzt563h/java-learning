package com.hzt.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzt.demo.model.User;

import java.util.List;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2021年03月22日 19:53:00
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> getList();
}
