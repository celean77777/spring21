package com.celean.spring21.mappers;

import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.models.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
   @Mapping(source = "category.title", target = "categoryTitle")
    ProductDto fromProduct(Product product);
    List<Product> toProductList(List<ProductDto> ProductDtos);
    @InheritInverseConfiguration
    Product toProduct(ProductDto productDto);
    List<ProductDto> fromProductList(List<Product> products);
}

