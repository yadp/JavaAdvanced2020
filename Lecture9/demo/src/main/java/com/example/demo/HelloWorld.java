package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {
    public HelloWorld(){
        System.out.println("test");
    }

    @PostConstruct
    public void sayHello() {
        System.out.println("Hello World, from Spring Boot 2!");
    }
}
