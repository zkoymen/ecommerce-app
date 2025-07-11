package com.ecommerce.ecommerce_app.mappers;


import com.ecommerce.ecommerce_app.dtos.order.OrderDTO;
import com.ecommerce.ecommerce_app.dtos.order.OrderItemDTO;
import com.ecommerce.ecommerce_app.entities.OrderItem;
import com.ecommerce.ecommerceapp.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "status", target = "status")
    OrderDTO toDto(com.ecommerce.ecommerceapp.entities.Order order);

    List<OrderDTO> toDtoList(List<Order> orders);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    OrderItemDTO orderItemToDto(OrderItem orderItem);

}
