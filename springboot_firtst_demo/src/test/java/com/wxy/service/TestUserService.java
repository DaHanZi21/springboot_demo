package com.wxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    void testSelectPage(){
        User user = new User();
        Page<User> users = userService.selectPage(1, 5,user);
        System.out.println(users);
    }
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setName("admin11");
        user.setUpdateTime(LocalDateTime.now());
        boolean result = userService.updateById(user);
        System.out.println(result);
    }
}
