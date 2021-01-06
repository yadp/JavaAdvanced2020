package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RestController
public class DemoApplication {

	private List<String> list=new ArrayList<>();
	private List<Dog> dogs=new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public List<String> hello(@RequestParam(value = "name",  defaultValue = "World") String name){
		list.add(name);
		return list;
	}

	@GetMapping("/dog")
	public List<Dog> getDog(){
		return dogs;
	}

	@PostMapping("/dog")
	public Dog createDog(@RequestParam String name, @RequestParam int age){
		Dog dog=new Dog();
		dog.setAge(age);
		dog.setName(name);
		dogs.add(dog);
		return dog;
	}


}
