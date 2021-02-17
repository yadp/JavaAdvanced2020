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
    private Client client;

    public Order(Book book, int quantity, Client client) {
        this.book = book;
        this.quantity = quantity;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
