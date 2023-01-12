package com.fabricio.curso;

import com.fabricio.curso.entities.User;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                                      //recurso API
@RequestMapping(value = "/users")                   //nome do recurso
public class UserResourse {

@GetMapping                                         //responde a requisição do HTPP end poit
    public ResponseEntity<User>findAll(){
        User u = new User(1, "maria", "maria@gmail.com", "99933394", "13325");
        return ResponseEntity.ok().body(u);
    }

}
