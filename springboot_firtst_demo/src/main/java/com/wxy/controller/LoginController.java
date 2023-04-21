package com.wxy.controller;

import com.wxy.domain.LoginUser;
import com.wxy.domain.Result;
import com.wxy.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/loginUser")
    Result select(String username, String password,String code,HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String myCode = (String) session.getAttribute("myCode");
        System.out.println("myCode = " + myCode);
        if (myCode.equalsIgnoreCase(code)){
            //验证码正确开始登陆操作
            LoginUser loginUser = loginService.selectByUsernameAndPassWord(username, password);
            if (loginUser != null) {
                session.setAttribute("loginUser",loginUser);
                resp.sendRedirect("/pages/users.html");
                return Result.success("登录成功", loginUser);
            } else {
                return Result.error("您输入的账号密码错误");
            }
        }else {
            return Result.error("验证码错误");
        }

    }

    @GetMapping("/login")
    Result getLoginUserName(HttpServletRequest req,HttpServletResponse resp){
        HttpSession session = req.getSession();
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        log.info("loginUser: {}",loginUser);
        return Result.success(loginUser);
    }
}
