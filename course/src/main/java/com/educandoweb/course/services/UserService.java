package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));// retorna o objeto do tipo user que estiver dentro do optional
    }

    public User insert(User obj){
        return repository.save(obj);

    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            //exceçao da minha camada de serviço
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        //atualiza os dados do entity com base nos dados do obj
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
