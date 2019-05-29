package com.example.sceurekap.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World 9006";
    }
}