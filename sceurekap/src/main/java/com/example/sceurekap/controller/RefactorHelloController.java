package com.example.sceurekap.controller;


import com.example.sceurekap.HelloService;
import com.example.sceurekap.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class RefactorHelloController implements HelloService {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World 9003";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello "+ user.getName() + ", " + user.getAge();
    }
}
