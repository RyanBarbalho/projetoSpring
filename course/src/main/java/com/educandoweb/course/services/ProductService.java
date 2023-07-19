package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

//registrado como componente
@Service // registra a classe como componente do spring e permite que seja injetado
         // automaticamente com o autowired
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // retorna todos os usuarios do banco de dados
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        // optional = container que vai carregar o objeto do tipo Product
        Optional<Product> obj = repository.findById(id);
        return obj.get();// retorna o objeto do tipo Product que estiver dentro do optional
    }

}
