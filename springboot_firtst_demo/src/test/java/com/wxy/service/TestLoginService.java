package com.wxy.service;

import com.wxy.domain.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLoginService {
    @Autowired
    private LoginService loginService;
    @Test
    void testSelectByUsernameAndPassWord(){
        String username = "admin1";
        String password = "admin";
        LoginUser result = loginService.selectByUsernameAndPassWord(username,password);
        System.out.println(result);
    }
}
