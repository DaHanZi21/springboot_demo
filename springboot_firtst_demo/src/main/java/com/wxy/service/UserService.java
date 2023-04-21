package com.wxy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wxy.domain.User;

import java.util.List;

public interface UserService extends IService<User> {


    //分页查询
    Page<User> selectPage(int currentPage, int pageSize, User user);
}
