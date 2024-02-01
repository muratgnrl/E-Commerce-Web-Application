package com.example.stoks.mapper;


import com.example.stoks.dto.CategoryDto;
import com.example.stoks.model.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public  interface CategoryMapper extends IEntityMapper<CategoryDto, Category>{
}
