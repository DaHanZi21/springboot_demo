package com.wxy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wxy.domain.LoginUser;
import com.wxy.domain.Result;
import com.wxy.domain.User;
import com.wxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //分页查询
    @GetMapping("{currentPage}/{pageSize}")
    Result selectPage(@PathVariable int currentPage, @PathVariable int pageSize, User user, HttpSession session) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
        System.out.println("loginUser:"+loginUser);
        if (loginUser != null){
            Page<User> page = userService.selectPage(currentPage, pageSize, user);
            if (currentPage > page.getPages()){
                page = userService.selectPage((int) page.getPages(), pageSize,user);
            }
            return Result.success(page);
        }else {
            return Result.error("请先登录后再查看");
        }

    }

    //根据ID查询
    @GetMapping("{id}")
    Result selectById(@PathVariable int id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    //添加用户
    @PostMapping
    Result save(@RequestBody User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        return Result.success(userService.save(user));
    }

    //更新信息
    @PutMapping
    public Result update(@RequestBody User user) {
        user.setUpdateTime(LocalDateTime.now());
        return Result.success(userService.updateById(user));
    }

    //删除信息
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }
}
