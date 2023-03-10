package com.fabricio.curso.config;

import com.fabricio.curso.entities.Category;
import com.fabricio.curso.entities.Order;
import com.fabricio.curso.entities.OrderItem;
import com.fabricio.curso.entities.Payment;
import com.fabricio.curso.entities.Product;
import com.fabricio.curso.entities.User;
import com.fabricio.curso.entities.enums.OrderStatus;
import com.fabricio.curso.repositories.CategoryRepository;
import com.fabricio.curso.repositories.OrderItemRepository;
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
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {          // tudo que for colocado nesse metodo vai ser execultado quando

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 100.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 5190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 3250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 2000.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 200.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
//coloando o pruduto na categoria //aspsociação de produtos
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); // a aplicação for executada
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3 ));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);// pra salvar oneToone manda salvar o pedito o jpa se encarrega pro pagamento
        

        orderRepository.save(o1);

    }

}

