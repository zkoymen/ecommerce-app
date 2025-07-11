package com.ecommerce.ecommerce_app.mappers;


import com.ecommerce.ecommerce_app.dtos.cart.CartItemDTO;
import com.ecommerce.ecommerce_app.dtos.cart.ShoppingCartDTO;
import com.ecommerce.ecommerce_app.entities.CartItem;
import com.ecommerce.ecommerce_app.entities.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "items", target = "items")
    ShoppingCartDTO toDto(ShoppingCart shoppingCart);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "price")
    CartItemDTO cartItemToDto(CartItem cartItem);
}
