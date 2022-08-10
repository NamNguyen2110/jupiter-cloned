package com.jupiter.oppsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.jupiter")
@EnableEurekaClient
public class OppsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OppsServiceApplication.class, args);
    }

}
