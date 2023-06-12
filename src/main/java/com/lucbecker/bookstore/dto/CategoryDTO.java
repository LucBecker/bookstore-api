package com.lucbecker.bookstore.dto;

import com.lucbecker.bookstore.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message = "NAME field is required")
    @Length(min = 3, max = 100, message = "The Name field must be between 3 and 100 characters long")
    private String name;
    @NotEmpty(message = "DESCRIPTION field is required")
    @Length(min = 3, max = 200, message = "The Description field must be between 3 and 200 characters long")
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Category obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
