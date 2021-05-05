package com.jindan.jdy.timing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.jindan.jdy.timing"})
@EnableScheduling
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApplicationTiming {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationTiming.class);
    }

}