package com.fabricio.curso.resources;

import com.fabricio.curso.entities.Order;
import com.fabricio.curso.entities.User;
import com.fabricio.curso.services.OrderService;
import com.fabricio.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                      //recurso API
@RequestMapping(value = "/orders")                   //nome do recurso
public class OrderResourse {

    @Autowired                                              // o UserResourse depende do UserService
    private OrderService service;                               // pra funcionar minha classe tem que ta registrada como string


    @GetMapping                                         //responde a requisição do HTPP end poit
    public ResponseEntity<List<Order>> findAll(){
   List<Order>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Order>findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
