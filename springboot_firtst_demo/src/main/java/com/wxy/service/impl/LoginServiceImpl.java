package com.wxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.domain.LoginUser;
import com.wxy.domain.User;
import com.wxy.mapper.LoginMapper;
import com.wxy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper,LoginUser> implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginUser selectByUsernameAndPassWord(String username,String password) {
        QueryWrapper<LoginUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",password);
        LoginUser findUser = loginMapper.selectOne(wrapper);
        if (findUser != null){
            return findUser;
        }else {
            return null;
        }
    }

    @Override
    public LoginUser selectByUsername(String username) {
        QueryWrapper<LoginUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        LoginUser findUser = loginMapper.selectOne(wrapper);
        if (findUser != null){
            return findUser;
        }else {
            return null;
        }
    }




}
