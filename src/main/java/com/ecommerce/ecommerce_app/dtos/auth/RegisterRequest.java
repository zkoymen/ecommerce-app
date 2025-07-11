package com.ecommerce.ecommerce_app.dtos.auth;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;



    @NotBlank
    @Size(max = 50)
    private String email;


    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String name;
    private String address;


}
