package com.ecommerce.ecommerce_app.mappers;

import com.ecommerce.ecommerce_app.dtos.ProductDTO;
import com.ecommerce.ecommerce_app.entities.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);
    ProductDTO toDTO(Product product);



    // every time you need a partial update you get the same behavior.
    // “every field, every time” boilerplate is exactly what MapStruct’s @MappingTarget was designed to eliminate.
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(ProductDTO dto, @MappingTarget Product entity);


}
