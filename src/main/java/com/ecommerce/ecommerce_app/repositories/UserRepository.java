package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
