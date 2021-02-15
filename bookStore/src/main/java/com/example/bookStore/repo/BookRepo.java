package com.example.bookStore.repo;

import com.example.bookStore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,Long> {
    Book findByName(String name);

    List<Book> findByNameContaining(String name);

    Book findByIsbn(String isbn);
}
