package com.example.bookStore.repo;

import com.example.bookStore.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Author,Long> {

    Author findByName(String name);
    List<Author> findByNameContains(String name);
}
