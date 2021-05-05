package com.edu.jdy.config;


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@MapperScan("com.online.edu.eduservice.mapper")
public class EduConfig {

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}