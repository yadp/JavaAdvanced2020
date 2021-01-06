package com.example.demo.calculator;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Collection;

@ComponentScan
@SpringBootApplication
public class CalculatorApplication {

    @Value("${number}")
    static String a;
    @Value("${number}")
    static String b;

    public static void main(String[] args) {
        var ctx = SpringApplication.run(CalculatorApplication.class, args);
        var calculator = ctx.getBean(Calculator.class);
        calculator.calculate(137, 21, '+');
        calculator.calculate(137, 21, '*');
        calculator.calculate(137, 21, '-');

        calculator.calculate(Integer.parseInt(a),Integer.parseInt(b), '+');


        for (String beanName : ctx.getBeanDefinitionNames()) {
           // System.out.println(beanName);
        }


    }







    @Bean
    public ApplicationRunner calculationRunner(Calculator calculator, @Value("${number}") int a) {
        System.out.println(a);
        calculator.calculate(5,3, '+');
        return args -> {

        };
    }
}
