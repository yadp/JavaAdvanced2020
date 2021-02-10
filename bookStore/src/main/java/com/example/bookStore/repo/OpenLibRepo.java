package com.example.bookStore.repo;

import com.example.bookStore.model.Book;
import com.example.bookStore.model.OpenLibBook;
import org.springframework.data.repository.Repository;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Repository
public class OpenLibRepo implements Repository<Book, Long> {

    RestTemplate restTemplate=new RestTemplate();

    public Book findByIsbn(String id){
        OpenLibBook openLibbook = restTemplate.getForObject("https://openlibrary.org/isbn/"+id+".json",OpenLibBook.class);

        Book book=new Book(openLibbook);
        return book;
    }
}
