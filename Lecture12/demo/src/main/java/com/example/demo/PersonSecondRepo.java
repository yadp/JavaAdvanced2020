package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonSecondRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public Person findId(long id){
        return jdbcTemplate.queryForObject("select * from Person where id=?",
                new Object[] {id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }
}
