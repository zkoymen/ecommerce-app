package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
