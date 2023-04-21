package com.wxy.controller;

import com.wxy.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class DeleteUserController {
    @RequestMapping("/deleteUser")
    Result delete(HttpSession session, HttpServletResponse resp) throws IOException {
        session.setAttribute("loginUser",null);
        resp.sendRedirect("/pages/users.html");
        return Result.success("注销用户成功");
    }
}
