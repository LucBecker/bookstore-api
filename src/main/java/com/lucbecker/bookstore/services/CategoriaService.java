package com.lucbecker.bookstore.services;

import com.lucbecker.bookstore.domain.Categoria;
import com.lucbecker.bookstore.dto.CategoriaDTO;
import com.lucbecker.bookstore.repositories.CategoriaRepository;
import com.lucbecker.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        if (objDTO.getNome() != null)
            obj.setNome(objDTO.getNome());
        if (objDTO.getDescricao() != null)
            obj.setDescricao(objDTO.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.lucbecker.bookstore.services.exceptions.DataIntegrityViolationException(
                    "Categoria não pode ser deletada! Possui livros associados");
        }
    }
}
