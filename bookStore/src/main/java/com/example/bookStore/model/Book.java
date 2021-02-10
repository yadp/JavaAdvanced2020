package com.example.bookStore.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column
    private String name;

    public Book(){

    }

    public Book(String isbn, Author author, String name) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(OpenLibBook openLibBook){
        this.name = openLibBook.getTitle();
        this.isbn = openLibBook.getIsbn()[0];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
