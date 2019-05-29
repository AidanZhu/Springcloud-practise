package com.example.sceureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SceurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SceurekaApplication.class, args);
    }

}
