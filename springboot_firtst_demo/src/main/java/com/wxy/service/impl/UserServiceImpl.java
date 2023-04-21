package com.wxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wxy.domain.User;
import com.wxy.mapper.UserMapper;
import com.wxy.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public Page<User> selectPage(int currentPage, int pageSize,User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(user.getType()),User::getType,user.getType());
        lqw.like(Strings.isNotEmpty(user.getName()),User::getName,user.getName());
        lqw.like(Strings.isNotEmpty(user.getDescription()),User::getDescription,user.getDescription());
        Page<User> page = new Page<>(currentPage,pageSize);
        return userMapper.selectPage(page,lqw);
    }
}
