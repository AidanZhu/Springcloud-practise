package com.example.feignconsumer;

public class User {

    private String name;
    private Integer age;

    //这里必须要有默认构造函数，不然，Spring Cloud Feign根据JSON字符串转换User对象时会抛出异常
    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" +age;
    }

}