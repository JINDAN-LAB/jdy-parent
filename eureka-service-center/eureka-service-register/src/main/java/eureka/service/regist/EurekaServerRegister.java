package eureka.service.regist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerRegister {

    public static void main(String[] args){
        SpringApplication.run(EurekaServerRegister.class, args);
    }

}
