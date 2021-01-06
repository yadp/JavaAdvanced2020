package com.example.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Zoo.class)
public class Config {
    @Bean
    public Animal getAnimal() {
        return new Dog();
    }
}