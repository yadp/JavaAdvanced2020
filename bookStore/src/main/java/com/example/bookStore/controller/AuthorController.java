package com.example.bookStore.controller;

import com.example.bookStore.model.Author;
import com.example.bookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/author/{id}")
    public @ResponseBody
    Author getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }
}
