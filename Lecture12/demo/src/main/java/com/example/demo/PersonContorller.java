package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PersonContorller {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonSecondRepo repo;

    @GetMapping("/test")
    public String test(){
        Person person=new Person("Test","Test");
        personRepository.save(person);
        System.out.println(personRepository.findAll());
        System.out.println(personRepository.findByName("Test"));
        System.out.println(personRepository.findByLastName("Test"));
        ArrayList<Long> list =new ArrayList<>();
        list.add(1L);
        personRepository.findAllById(list);


        System.out.println(repo.findId(1L));

        return "test";
    }
}
