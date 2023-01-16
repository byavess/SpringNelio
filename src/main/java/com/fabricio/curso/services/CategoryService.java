package com.fabricio.curso.services;

import com.fabricio.curso.entities.Category;
import com.fabricio.curso.entities.User;
import com.fabricio.curso.repositories.CategoryRepository;
import com.fabricio.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                                      //registra a classe como serviço do string
    public class CategoryService {

    @Autowired                                  //injeção de dependencia
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }
//recuperea o usuario por id
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();       //retorna o objeto do tipo User
    }


}
