package com.example.sceurekap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SceurekapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SceurekapApplication.class, args);
    }

}
