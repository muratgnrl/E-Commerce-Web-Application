package com.example.stoks.mapper;

import com.example.stoks.dto.ProductDto;
import com.example.stoks.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product>{
}
