package com.lucbecker.bookstore.services;

import com.lucbecker.bookstore.domain.Category;
import com.lucbecker.bookstore.domain.Book;
import com.lucbecker.bookstore.repositories.CategoriaRepository;
import com.lucbecker.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Category cat1 = new Category(null, "Informatica", "Livros de TI");
        Category cat2 = new Category(null, "Ficção Científica", "Ficção Científica");
        Category cat3 = new Category(null, "Biografias", "Livros de Biografias");

        Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book l2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
        Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
        Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
        Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
