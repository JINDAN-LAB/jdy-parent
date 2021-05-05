package com.edu.jdy.config;

import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 消息队列的配置信息
@Configuration
public class BeanConfig {


    @Value("${my_queue}")
    private String myQueue;

    @Bean
    public Queue queue()
    {
        return new ActiveMQQueue(myQueue);
    }



}
