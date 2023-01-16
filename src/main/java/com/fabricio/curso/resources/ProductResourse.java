package com.fabricio.curso.resources;

import com.fabricio.curso.entities.Category;
import com.fabricio.curso.entities.Product;
import com.fabricio.curso.services.CategoryService;
import com.fabricio.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                      //recurso API
@RequestMapping(value = "/products")                   //nome do recurso
public class ProductResourse {

    @Autowired                           // o UserResourse depende do UserService
    private ProductService service;                        // pra funcionar minha classe tem que ta registrada como string
    @GetMapping                                         //responde a requisição do HTPP end poit
    public ResponseEntity<List<Product>>findAll(){
    List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
