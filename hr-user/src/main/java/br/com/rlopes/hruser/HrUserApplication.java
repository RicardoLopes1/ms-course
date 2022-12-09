package br.com.rlopes.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //log.info("BCRYPT = " + passwordEncoder.encode("123456"));
        log.info("Application started!");
    }

}
