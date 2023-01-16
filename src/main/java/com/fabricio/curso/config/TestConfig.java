package com.fabricio.curso.config;

import com.fabricio.curso.entities.Category;
import com.fabricio.curso.entities.Order;
import com.fabricio.curso.entities.Product;
import com.fabricio.curso.entities.User;
import com.fabricio.curso.repositories.CategoryRepository;
import com.fabricio.curso.repositories.OrderRepository;
import com.fabricio.curso.repositories.ProductRepository;
import com.fabricio.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//essa classe vai servir pra fazer a população do banco de dados
@Configuration                                                //mostra que e uma clsse de configuração
@Profile("test")                                              //vai rodar a aplicação somente no teste
public class TestConfig implements CommandLineRunner {        //implements CommandLineRunnerpro programa ser iniciado
    @Autowired                                               //fazer um objeto que depende de outro.. vai assossiar o     // userRepository aqui dentro
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {          // tudo que for colocado nesse metodo vai ser execultado quando

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // a aplicação for executada
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);//z time zone gmt pdrão utc genuino
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2)); //   criando na tela
        orderRepository.saveAll(Arrays.asList(o1, o2, o3 ));
    }

}

