package com.ecommerce.ecommerce_app.mappers;


import com.ecommerce.ecommerce_app.dtos.user.UserDTO;
import com.ecommerce.ecommerce_app.entities.Role;
import com.ecommerce.ecommerce_app.entities.User;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {


    // Why do we need it ???
    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToString")
    User toEntity(UserDTO dto);
    UserDTO toDTO(User user);


    // defined here
    @Named("rolesToString")
    default Set<String> rolesToString(Set<Role> roles) {
        if(roles ==null) {
            return null;
        }

        return roles.stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
    }
}
