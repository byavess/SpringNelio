package com.fabricio.curso.services;

import com.fabricio.curso.entities.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

    @Service                                                               //registra a classe como serviço do string
    public class OrderService  {

    @Autowired                                                                //injeção de dependencia
    private OrderService repository;

    public List<Order> findAll() {
        return repository.findAll();
    }
                                                                                    //recuperea o usuario por id
    public Order findById(Long id) {
        Optional<Order> obj = Optional.ofNullable(repository.findById(id));
        return obj.get();                                                                   //retorna o objeto do tipo
    }


}
