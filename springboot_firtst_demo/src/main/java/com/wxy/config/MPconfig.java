package com.wxy.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class MPconfig implements HandlerInterceptor {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mpinterceptor = new MybatisPlusInterceptor();
        mpinterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpinterceptor;
    }
}
