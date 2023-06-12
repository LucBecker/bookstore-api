package com.lucbecker.bookstore.controller;

import com.lucbecker.bookstore.domain.Book;
import com.lucbecker.bookstore.domain.Category;
import com.lucbecker.bookstore.dto.BookDTO;
import com.lucbecker.bookstore.dto.CategoryDTO;
import com.lucbecker.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(
            @RequestParam(value = "category", defaultValue = "0") Integer id_cat){
        List<Book> list = service.findAll(id_cat);
        List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj){
      Book newObj = service.update(id, obj);
      return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
