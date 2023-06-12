package com.lucbecker.bookstore.services;

import com.lucbecker.bookstore.domain.Category;
import com.lucbecker.bookstore.dto.CategoryDTO;
import com.lucbecker.bookstore.repositories.CategoryRepository;
import com.lucbecker.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Tipo: " + Category.class.getName()));
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category create(Category obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Category update(Integer id, CategoryDTO objDTO) {
        Category obj = findById(id);
        if (objDTO.getName() != null)
            obj.setName(objDTO.getName());
        if (objDTO.getDescription() != null)
            obj.setDescription(objDTO.getDescription());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.lucbecker.bookstore.services.exceptions.DataIntegrityViolationException(
                    "Category cannot be deleted! Has associated books");
        }
    }
}
