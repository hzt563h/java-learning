package com.hzt.demo;

import com.hzt.demo.mapper.UserMapper;
import com.hzt.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName WjtestApplicationTests.java
 * @Description TODO
 * @createTime 2021年03月22日 19:49:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WjtestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        User user = new User();
        user.setAge(1);
        user.setEmail("123");
        user.setName("测试");
        Integer num = this.userMapper.insert(user);
    }
}
