package com.example.ribbonconsumer.Controller;

import com.example.ribbonconsumer.domain.User;
import com.example.ribbonconsumer.hystrix.UserCollapseCommand;
import com.example.ribbonconsumer.service.HelloService;
import com.example.ribbonconsumer.service.UserService;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @Autowired
    UserService userService;

    @GetMapping(value = "ribbon-consumer")
    public Object helloConsumer(){
        return helloService.helloService();
        //return restTemplate.exchange("http://SERIVCE-USER/hello", HttpMethod.GET, null, String.class).getBody();
        //return restTemplate.getForEntity("http://SERIVCE-USER/hello",String.class).getBody();
    }

    @RequestMapping("/combination-test")
    public void getUserBatchTest() throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        UserCollapseCommand bc1 = new UserCollapseCommand(userService, 1l);
        UserCollapseCommand bc2 = new UserCollapseCommand(userService, 2l);
        UserCollapseCommand bc3 = new UserCollapseCommand(userService, 3l);
        UserCollapseCommand bc4 = new UserCollapseCommand(userService, 4l);
        Future<User> q1 = bc1.queue();
        Future<User> q2 = bc2.queue();
        Future<User> q3 = bc3.queue();
        User user1 = q1.get();
        User user2 = q2.get();
        User user3 = q3.get();
        Thread.sleep(3000);
        Future<User> q4 = bc4.queue();
        User user4 = q4.get();
        System.out.println("user1>>>"+user1);
        System.out.println("user2>>>"+user2);
        System.out.println("user3>>>"+user3);
        System.out.println("user4>>>"+user4);
        context.close();
    }
}