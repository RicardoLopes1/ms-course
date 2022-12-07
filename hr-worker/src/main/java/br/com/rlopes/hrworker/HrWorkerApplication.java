package br.com.rlopes.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
public class HrWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }


}
