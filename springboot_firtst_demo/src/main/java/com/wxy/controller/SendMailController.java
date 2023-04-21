package com.wxy.controller;

import com.wxy.domain.LoginUser;
import com.wxy.domain.Result;
import com.wxy.mapper.LoginMapper;
import com.wxy.service.LoginService;
import com.wxy.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SendMailController {
    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/sendmail/{email}")
    Result sendMail(@PathVariable String email, HttpSession session){
            //返回验证码
            String code = sendMailService.sendMail(email);
            session.setAttribute("code",code);
            return Result.success(code);


    }
}
