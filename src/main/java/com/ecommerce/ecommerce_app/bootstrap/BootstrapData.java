package com.ecommerce.ecommerce_app.bootstrap;

import com.ecommerce.ecommerce_app.repositories.ProductRepository;
import com.ecommerce.ecommerce_app.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    }
}
