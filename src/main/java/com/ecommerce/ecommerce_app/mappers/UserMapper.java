package com.ecommerce.ecommerce_app.mappers;


import com.ecommerce.ecommerce_app.dtos.UserDTO;
import com.ecommerce.ecommerce_app.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);
}
