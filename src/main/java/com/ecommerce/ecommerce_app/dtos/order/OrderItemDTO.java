package com.ecommerce.ecommerce_app.dtos.order;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;

}
