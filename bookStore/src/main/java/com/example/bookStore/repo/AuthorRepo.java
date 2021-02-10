package com.example.bookStore.repo;

import com.example.bookStore.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Long> {
}
