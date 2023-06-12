package com.lucbecker.bookstore.dto;

import com.lucbecker.bookstore.domain.Category;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String authorName;
    private String text;

    public BookDTO() {
    }

    public BookDTO(Integer id, String title, String authorName, String text) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.text = text;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
