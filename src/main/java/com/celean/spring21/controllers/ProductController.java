package com.celean.spring21.controllers;

import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.mappers.ProductMapper;
import com.celean.spring21.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts().stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto product) {
        return productMapper.fromProduct(productService.create(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}