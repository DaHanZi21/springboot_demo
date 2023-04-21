package com.wxy.controller;

import com.wxy.domain.LoginUser;
import com.wxy.domain.Result;
import com.wxy.service.LoginService;
import com.wxy.service.SendMailService;
import com.wxy.service.impl.SendMailServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
public class RegisterController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    Result save(LoginUser loginuser, HttpServletResponse resp, HttpSession session) throws IOException {
        String code = (String) session.getAttribute("code");
        System.out.println("邮箱的验证码为：" + code);
        System.out.println(loginuser);
        if (!loginuser.getEmail().contains("@qq.com") && Strings.isEmpty(loginuser.getEmail())) {
            return Result.error("你输入的qq邮箱不正确。");
        }
        if (!code.equals(loginuser.getCode()) && loginuser.getCode() != null) {
            return Result.error("你输入的验证码不正确");
        }

        if (loginuser.getUsername() != null && Strings.isNotEmpty(loginuser.getUsername())
                && loginuser.getPassword() != null && Strings.isNotEmpty(loginuser.getPassword())) {
            loginuser.setCreateTime(LocalDateTime.now());
            loginuser.setUpdateTime(LocalDateTime.now());
            loginuser.setStatus(1);
            boolean save = loginService.save(loginuser);
            resp.sendRedirect("/pages/login.html");
            return Result.success(save);
        } else {
            return Result.error("请输入用户名和密码。");
        }


    }
}
