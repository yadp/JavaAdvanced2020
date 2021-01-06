package com.example.demo;

import com.example.demo.calculator.Calculator;
import com.example.demo.test.Config;
import com.example.demo.test.Zoo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	Logger log = LoggerFactory.getLogger(DemoApplication.class);


	@Value("${number}")
	static String a;

	public static void main(String[] args) {
		System.out.println(a);
		SpringApplication.run(DemoApplication.class, args);
	}



	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		log.info("Called hello method");
		return String.format("Hello %s!", name);
	}
}
