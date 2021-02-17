package com.example.bookStore.controller;

import com.example.bookStore.model.Book;
import com.example.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/search")
    public @ResponseBody
    List<Book> searchForBook(@RequestBody String query){
       return bookService.getBookByNamePart(query);
    }

    @GetMapping("/{id}")
    public @ResponseBody Book getBook(@PathVariable Long id){
        Book book;
        try {
            book = bookService.getBook(id);
        } catch (NullPointerException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
        }
        return book;
    }

    @PostMapping("/")
    public @ResponseBody Book createBook(@RequestBody Book book){
        book.setId(null);

        if(book.getIsbn()!=null) {
            return bookService.createBook(book);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing isbn");
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        return bookService.updatePrice(id,book.getPrice());
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
