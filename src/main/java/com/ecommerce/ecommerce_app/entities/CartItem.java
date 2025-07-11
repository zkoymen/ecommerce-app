package com.ecommerce.ecommerce_app.entities;


import jakarta.persistence.*;
import lombok.*;

import javax.sound.sampled.Port;

@Data
@Builder
@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@RequiredArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // shoppingCart
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private  ShoppingCart shoppingCart;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;



}
