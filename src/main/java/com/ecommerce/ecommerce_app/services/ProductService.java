package com.ecommerce.ecommerce_app.services;

import com.ecommerce.ecommerce_app.dtos.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    // Service → Mapper → Controller → DTO
    ProductDTO create(ProductDTO dto);
    Optional<ProductDTO> getById(Long id);
    List<ProductDTO> listAll();
    void  update(Long id, ProductDTO dto);
    void  delete(Long id);
}
