package com.ecommerce.ecommerce_app.bootstrap;

import com.ecommerce.ecommerce_app.entities.Product;
import com.ecommerce.ecommerce_app.entities.User;
import com.ecommerce.ecommerce_app.repositories.ProductRepository;
import com.ecommerce.ecommerce_app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    // Constructor injection
    public BootstrapData(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Sample entities

        User user1 = User.builder()
                .username("alice")
                .password("password")
                .build();

        Product product1 = Product.builder()
                .name("Widget")
                .description("A demo product")
                .price(BigDecimal.valueOf(9.99))
                .stockQuantity(100)
                .build();


        userRepository.save(user1);
        productRepository.save(product1);

        System.out.println("Seeder done: users=" + userRepository.count() + ", products=" + productRepository.count());

    }
}
