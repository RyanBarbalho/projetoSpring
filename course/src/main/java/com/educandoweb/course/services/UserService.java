package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//registrado como componente
@Service // registra a classe como componente do spring e permite que seja injetado
         // automaticamente com o autowired
public class UserService {
    @Autowired
    private UserRepository repository;

    // retorna todos os usuarios do banco de dados
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        // optional = container que vai carregar o objeto do tipo user
        Optional<User> obj = repository.findById(id);
        return obj.get();// retorna o objeto do tipo user que estiver dentro do optional
    }

    public User insert(User obj){
        return repository.save(obj);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
