package com.ecommerce.ecommerce_app.dtos.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDTO {

    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
}

