package com.celean.spring21.mappers;

import com.celean.spring21.dto.CategoryDto;
import com.celean.spring21.models.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {
    Category toCategory(CategoryDto categoryDto);
    @InheritInverseConfiguration
    CategoryDto fromCategory(Category category);
    List<Category> toCategoryList(List<CategoryDto> categoryDtos);
    List<CategoryDto> fromCategoryList(List<Category> categories);
}

