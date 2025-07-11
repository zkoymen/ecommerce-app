package com.ecommerce.ecommerce_app.dtos.order;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    // Order -- PREVIOUS ORDER, ORDER HISTORY
    private Long id;
    private Long userId;
    private List<OrderItemDTO> orderItems;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;


}


