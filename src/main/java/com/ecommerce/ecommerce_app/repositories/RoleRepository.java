package com.ecommerce.ecommerce_app.repositories;

import com.ecommerce.ecommerce_app.entities.Role;
import com.ecommerce.ecommerce_app.entities.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
