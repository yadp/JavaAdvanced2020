package com.example.bookStore.service;

import com.example.bookStore.model.Author;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.OpenLibBook;
import com.example.bookStore.repo.AuthorRepo;
import com.example.bookStore.repo.BookRepo;
import com.example.bookStore.repo.OpenLibRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private OpenLibRepo openLibRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public boolean createBook(Book book) {

        if ((book.getAuthor().getId()!=null
                && !authorRepo.existsById(book.getAuthor().getId()))
        || book.getAuthor().getId()==null){
            book.setAuthor(authorRepo.save(book.getAuthor()));
        }
        if(bookRepo.save(book)!= null) {
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updatePrice(Long id, Double newPrice) {
        if(newPrice < 0 ){
            return false;
        }
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(!optionalBook.isEmpty()){
            Book book = optionalBook.get();
            book.setPrice(newPrice);
            bookRepo.save(book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sellBook(Long id, int quantity) {
        if(quantity < 0 ){
            return false;
        }
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(!optionalBook.isEmpty()){
            Book book = optionalBook.get();
            book.sellBook(quantity);
            bookRepo.save(book);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addBookQuantity(Long id, int quantity) {
        if(quantity < 0 ){
            return false;
        }
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(!optionalBook.isEmpty()){
            Book book = optionalBook.get();
            book.addBook(quantity);
            bookRepo.save(book);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param id
     * @return null if not found
     */
    @Override
    public Book getBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(!optionalBook.isEmpty()) {
            Book book = optionalBook.get();
            return book;
        } else {
            return null;
        }
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepo.findByName(name);
    }

    @Override
    public List<Book> getBookByNamePart(String name) {
        List<Book> books = bookRepo.findByNameContaining(name);
        return books;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book bookLocal= bookRepo.findByIsbn(isbn);
        if(bookLocal==null){
            bookLocal = bookRepo.save(openLibRepo.findByIsbn(isbn));
        }
        return bookLocal;
    }

}
