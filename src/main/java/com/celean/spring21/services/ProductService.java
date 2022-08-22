package com.celean.spring21.services;

import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.mappers.ProductMapper;
import com.celean.spring21.models.Product;
import com.celean.spring21.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductDto dto) {
        return productRepository.save(productMapper.toProduct(dto));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
