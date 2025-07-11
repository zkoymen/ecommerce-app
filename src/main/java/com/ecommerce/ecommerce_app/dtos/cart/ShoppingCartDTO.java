package com.ecommerce.ecommerce_app.dtos.cart;


import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDTO {

    private Long id;
    private Long userId;
    private List<CartItemDTO> items;
}
