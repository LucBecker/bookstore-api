package com.lucbecker.bookstore.dto;

import com.lucbecker.bookstore.domain.Book;
import com.lucbecker.bookstore.domain.Category;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDTO() {
    }

    public BookDTO(Book obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
