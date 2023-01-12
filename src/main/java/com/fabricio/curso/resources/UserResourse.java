package com.fabricio.curso.resources;

import com.fabricio.curso.entities.User;
import com.fabricio.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                      //recurso API
@RequestMapping(value = "/users")                   //nome do recurso
public class UserResourse {

    @Autowired // o UserResourse depende do UserService
    private UserService service; // pra funcionar minha classe tem que ta registrada como string
    @GetMapping                                         //responde a requisição do HTPP end poit
    public ResponseEntity<List<User>>findAll(){

//        User u = new User(1, "maria", "maria@gmail.com", "99933394", "13325");//feita manual mocada
    List<User>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
