package com.wxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wxy.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
