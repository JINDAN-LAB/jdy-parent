package fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration= MySelfRule.class)
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer82_App {

        public static void main(String[] args){
            SpringApplication.run(DeptConsumer82_App.class, args);
        }

}
