package com.mine.service.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 */
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PersonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }
}