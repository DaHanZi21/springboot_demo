package com.wxy.mapper;

import com.wxy.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {

    @Autowired
    private UserMapper userMapper;

    @Test
    void test1() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
