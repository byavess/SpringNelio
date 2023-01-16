package com.fabricio.curso.services;

import com.fabricio.curso.entities.Category;
import com.fabricio.curso.entities.Product;
import com.fabricio.curso.repositories.CategoryRepository;
import com.fabricio.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                                      //registra a classe como serviço do string
    public class ProductService {

    @Autowired                                  //injeção de dependencia
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
//recuperea o usuario por id
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();       //retorna o objeto do tipo User
    }


}
