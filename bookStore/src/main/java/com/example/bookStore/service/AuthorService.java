package com.example.bookStore.service;

import com.example.bookStore.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    Author getAuthorByName(String name);
    Author getAuthor(Long id);

    List<Author> getAuthorByPartName(String name);

    boolean saveAuthor(Author author);
    void deleteAuthor(Long id);

    void updateAuthor(Author author);


}
