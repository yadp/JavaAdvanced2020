package com.example.bookStore.repo;

import com.example.bookStore.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long> {

    Book findByIsbn(String isbn);
}
