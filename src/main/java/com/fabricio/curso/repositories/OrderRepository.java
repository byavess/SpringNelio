package com.fabricio.curso.repositories;

import com.fabricio.curso.entities.Order;
import com.fabricio.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long>{


}




