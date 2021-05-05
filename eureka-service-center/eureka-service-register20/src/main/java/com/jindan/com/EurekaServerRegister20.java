package com.jindan.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerRegister20 {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerRegister20.class, args);

    }


}
