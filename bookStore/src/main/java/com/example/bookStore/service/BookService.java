package com.example.bookStore.service;

import com.example.bookStore.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Book service to handle CRUD request for Book Store.
 */
@Service
public interface BookService {


    /**
     *
     * @param book
     * @return
     */
    Book createBook( Book book );

    /**
     *
     * @param id
     * @param newPrice
     * @return
     */
    Book updatePrice( Long id, Double newPrice);

    /**
     *
     * @param id
     * @param quantity
     * @return
     */
    boolean sellBook( Long id, int quantity);

    /**
     *
     * @param id
     * @param quantity
     * @return
     */
    boolean addBookQuantity(Long id, int quantity);

    /**
     *
     * @param id
     * @return
     */
    Book getBook(Long id);

    /**
     * Find this book by name
     * @param name
     * @return
     */
    Book getBookByName(String name);


    List<Book> getBookByNamePart(String name);

    /**
     *
     * @param isbn
     * @return
     */
    Book getBookByIsbn(String isbn);

    /**
     *
     * @param id
     */
    void deleteBook(Long id);

}
