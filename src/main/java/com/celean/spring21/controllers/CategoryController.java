package com.celean.spring21.controllers;

import com.celean.spring21.dto.CategoryDto;
import com.celean.spring21.mappers.CategoryMapper;
import com.celean.spring21.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.findAll()
                .stream()
                .map(categoryMapper::fromCategory)
                .collect(Collectors.toList());
    }


    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId) {
        return categoryService.findById(categoryId)
                .map(categoryMapper::fromCategory)
                .orElseThrow(() -> new EntityNotFoundException("Category " + categoryId + " is not found"));
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryMapper.fromCategory(categoryService.create(categoryDto));
    }

//    @PostMapping
//    public CategoryDto createCategoryFromTitle(@RequestBody String title){
//        return categoryMapper.fromCategory(categoryService.create(title));
//    }
}