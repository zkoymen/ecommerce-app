package com.ecommerce.ecommerce_app.mappers;

import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);
    ProductDTO toDTO(Product product);
}
