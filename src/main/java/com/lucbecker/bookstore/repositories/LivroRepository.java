package com.lucbecker.bookstore.repositories;

import com.lucbecker.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Book, Integer> {
}
