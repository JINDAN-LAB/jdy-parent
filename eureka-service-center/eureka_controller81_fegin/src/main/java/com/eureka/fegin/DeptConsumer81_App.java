package com.eureka.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"atsliyun.service"})
@ComponentScan("com.eureka.fegin")
public class DeptConsumer81_App {

        public static void main(String[] args){
            SpringApplication.run(DeptConsumer81_App.class, args);
        }

}
