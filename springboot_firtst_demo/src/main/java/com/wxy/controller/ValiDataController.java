package com.wxy.controller;



import cn.dsna.util.images.ValidateCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class ValiDataController {
    @RequestMapping("/getCode")
    void getCode(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ValidateCode vc = new ValidateCode(120, 30, 4, 50);
        System.out.println("登录界面的验证码为：" + vc.getCode());
        vc.write(resp.getOutputStream());
        session.setAttribute("myCode", vc.getCode());
    }

}
