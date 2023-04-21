package com.wxy.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.wxy.domain.LoginUser;
import com.wxy.domain.Result;
import com.wxy.service.LoginService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
public class ModifyController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/modify")
    Result update(LoginUser loginuser, HttpServletResponse resp, HttpSession session) throws IOException {
        String code = (String) session.getAttribute("code");
        System.out.println(code);
        System.out.println(loginuser);
        if (!loginuser.getEmail().contains("@qq.com") && loginuser.getEmail() != null && Strings.isNotEmpty(loginuser.getEmail())) {
            return Result.error("你输入的qq邮箱不正确。");
        }
        if (!code.equals(loginuser.getCode()) && loginuser.getCode() != null && Strings.isNotEmpty(loginuser.getCode())) {
            return Result.error("你输入的验证码不正确");
        }

        if (loginuser.getUsername() != null && Strings.isNotEmpty(loginuser.getUsername())
                && loginuser.getPassword() != null && Strings.isNotEmpty(loginuser.getPassword())) {

            LoginUser resultUser = loginService.selectByUsername(loginuser.getUsername());
            resultUser.setUpdateTime(LocalDateTime.now());
            resultUser.setPassword(loginuser.getPassword());
            resultUser.setCode(code);

            UpdateWrapper<LoginUser> wrapper = new UpdateWrapper<>();
            wrapper.eq("username", resultUser.getUsername());
            boolean update = loginService.updateById(resultUser);
            resp.sendRedirect("/pages/login.html");
            return Result.success(update);
        } else {
            return Result.error("请输入用户名和密码。");
        }


    }
}
