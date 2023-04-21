package com.wxy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.domain.LoginUser;

public interface LoginService extends IService<LoginUser> {
    //根据用户名和密码查询
    LoginUser selectByUsernameAndPassWord(String username, String password);

    //更具用户名查询
    LoginUser selectByUsername(String username);

}
