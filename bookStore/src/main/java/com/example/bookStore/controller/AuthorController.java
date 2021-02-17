package com.example.bookStore.controller;

import com.example.bookStore.model.Author;
import com.example.bookStore.service.AuthorService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/{id}")
    public @ResponseBody
    Author getAuthor(@PathVariable Long id){
        try {
            return authorService.getAuthor(id);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @PostMapping("/")
    public @ResponseBody Author createAuthor(@RequestBody Author author){
        if( author.getName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Didn't include author name");
        }
        return authorService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public @ResponseBody Author updateAuthor(@RequestBody Author author, Long id){
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Author> searchAuthor(@RequestBody String query){
        return authorService.getAuthorByPartName(query);
    }
}
