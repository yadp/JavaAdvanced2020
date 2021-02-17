package com.example.bookStore.service;

import com.example.bookStore.model.Author;
import com.example.bookStore.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepo authorRepo;

    @Override
    public Author getAuthorByName(String name) {
        return authorRepo.findByName(name);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public List<Author> getAuthorByPartName(String name) {
        return authorRepo.findByNameContains(name);
    }

    @Override
    public boolean saveAuthor(Author author) {
        authorRepo.save(author);
        return true;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

    @Override
    public void updateAuthor(Author author) {
        authorRepo.save(author);
    }
}
