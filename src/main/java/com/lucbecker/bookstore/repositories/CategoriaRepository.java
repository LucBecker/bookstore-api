package com.lucbecker.bookstore.repositories;

import com.lucbecker.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Category, Integer> {
}
