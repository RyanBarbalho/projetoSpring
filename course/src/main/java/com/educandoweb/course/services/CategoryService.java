package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

//registrado como componente
@Service // registra a classe como componente do spring e permite que seja injetado
         // automaticamente com o autowired
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    // retorna todos os usuarios do banco de dados
    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        // optional = container que vai carregar o objeto do tipo Category
        Optional<Category> obj = repository.findById(id);
        return obj.get();// retorna o objeto do tipo Category que estiver dentro do optional
    }

}
