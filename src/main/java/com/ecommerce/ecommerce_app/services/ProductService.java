package com.ecommerce.ecommerce_app.services;

import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.entities.Product;

import java.util.List;

public interface ProductService {


    // Service → Mapper → Controller → DTO
    ProductDTO create(ProductDTO dto);
    ProductDTO getById(Long id);
    List<ProductDTO> listAll();
    ProductDTO update(Long id, ProductDTO dto);
    void delete(Long id);
}
