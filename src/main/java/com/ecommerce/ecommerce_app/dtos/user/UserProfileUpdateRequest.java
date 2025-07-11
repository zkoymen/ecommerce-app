package com.ecommerce.ecommerce_app.dtos.user;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserProfileUpdateRequest {

    @Email
    @Size(max = 50)
    private String email;

    @Size(min = 6, max = 40)
    private String password; // Optional: only if they want to change it

    private String name;
    private String address;
}
