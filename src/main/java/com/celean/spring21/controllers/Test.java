package com.celean.spring21.controllers;

import com.celean.spring21.cart.Cart;
import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.mappers.ProductMapper;
import com.celean.spring21.models.Product;
import com.celean.spring21.services.CartService;
import com.celean.spring21.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@Slf4j
public class Test {
    private final ProductService productService;
    private final ProductMapper productMapper;

    private final CartService cartService;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<ProductDto> list = productService.getProducts()
                .stream().map(productMapper::fromProduct)
                .collect(Collectors.toList());
        log.debug("{}", list);
        return list;
    }

    @GetMapping("/cart")
    public Cart getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }


}
