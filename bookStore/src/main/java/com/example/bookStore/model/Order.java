package com.example.bookStore.model;

import javax.persistence.*;

@Entity
@Table(name = "StoreOrder")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn( name = "book_id")
    private Book book;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    public Order(Book book, int quantity, User user) {
        this.book = book;
        this.quantity = quantity;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getClient() {
        return user;
    }

    public void setClient(User user) {
        this.user = user;
    }
}
