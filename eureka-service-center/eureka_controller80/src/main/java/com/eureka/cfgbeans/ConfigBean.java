package com.eureka.cfgbeans;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.RunnableFuture;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public IRule myTule(){
////        return new RoundRobinRule();
////        return  new RandomRule();  // 达到的目的，用我们重新选择 的随机算法默认代替
//        return  new RetryRule();   //轮训算法
//
//    }


}
