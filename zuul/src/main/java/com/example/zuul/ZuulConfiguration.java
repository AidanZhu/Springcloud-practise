package com.example.zuul;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
