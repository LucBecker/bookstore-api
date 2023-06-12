package com.lucbecker.bookstore.services;

import com.lucbecker.bookstore.domain.Book;
import com.lucbecker.bookstore.repositories.BookRepository;
import com.lucbecker.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book findById(Integer id){
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Tipo: " + Book.class.getName()));
    }
}
