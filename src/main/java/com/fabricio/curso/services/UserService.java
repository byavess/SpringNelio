package com.fabricio.curso.services;

import com.fabricio.curso.entities.User;
import com.fabricio.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                                      //registra a classe como serviço do string
    public class UserService {

    @Autowired                                  //injeção de dependencia
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
//recuperea o usuario por id
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();       //retorna o objeto do tipo User
    }


}
