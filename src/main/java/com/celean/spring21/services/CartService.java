package com.celean.spring21.services;

import com.celean.spring21.cart.Cart;
import com.celean.spring21.cart.CartItem;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Cacheable(value = "cart")
    public Cart getCart(Long userId) {
        Cart cart = new Cart();
        CartItem item = CartItem.builder()
                .id(1L)
                .title("Cheese")
                .count(2L)
                .price(100.)
                .sum(200.)
                .build();

        cart.setUserId(userId);
        cart.setItems(List.of(item));
        return cart;
    }

    @CacheEvict(value = "cart")
    public void clear(Long userId) {}

}
