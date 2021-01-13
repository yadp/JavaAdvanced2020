package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository
        extends
        JpaRepository<Person, Long> {


    List<Person> findByName(String name);

    List<Person> findByLastName(String lastName);


}
