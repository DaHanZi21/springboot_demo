package com.wxy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSendMailService {
    @Autowired
    private SendMailService sendMailService;

    @Test
    void testSendMail(){
        sendMailService.sendMail("1574351429@qq.com");
    }
}
