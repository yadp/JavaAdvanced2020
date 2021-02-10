package com.example.bookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenLibBook {

    private  String title;

    @JsonProperty("isbn_10")
    private String[] isbn;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getIsbn() {
        return isbn;
    }
}
