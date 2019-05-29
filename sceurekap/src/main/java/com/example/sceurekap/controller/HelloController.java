package com.example.sceurekap.controller;

import com.example.sceurekap.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class HelloController {

    @GetMapping(value = "/hello10")
    public String hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        //log.info("sleepTime:"+sleepTime);
        Thread.sleep(sleepTime);
        return "Hello World 9003";
    }

    @GetMapping(value = "/getUserInfo/{id}")
    public User getUserInfo(@PathVariable String id){
        return new User("张三",20);
    }

    @GetMapping(value = "/getUserInfos/{ids}")
    public List<User> getUserInfos(@PathVariable String ids){
        System.out.println("getUserInfos---------"+ids+"Thread.currentThread().getName():" + Thread.currentThread().getName());
        List<User> list = new ArrayList<>();
        list.add(new User("张三",20));
        list.add(new User("李四",21));
        list.add(new User("王五",22));
        return list;
    }
}