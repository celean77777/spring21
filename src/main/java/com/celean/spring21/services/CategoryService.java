package com.celean.spring21.services;

import com.celean.spring21.dto.CategoryDto;
import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.mappers.CategoryMapper;
import com.celean.spring21.models.Category;
import com.celean.spring21.models.Product;
import com.celean.spring21.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(String title) {
        Category category = new Category();
        category.setTitle(title);
        return categoryRepository.save(category);
    }

    public Category create(CategoryDto dto) {
        Category category = new Category();
        category.setTitle(dto.getTitle());
        return categoryRepository.save(category);
    }


}
