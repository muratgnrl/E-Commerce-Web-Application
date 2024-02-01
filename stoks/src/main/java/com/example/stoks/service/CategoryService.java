package com.example.stoks.service;

import com.example.stoks.dto.CategoryDto;
import com.example.stoks.exception.categoryBaseException.CreateCategoryException;
import com.example.stoks.exception.categoryBaseException.DeleteCategoryException;
import com.example.stoks.exception.categoryBaseException.FindCategoryException;
import com.example.stoks.response.CategoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    CategoryResponse addCategory(CategoryDto categoryDto) throws CreateCategoryException;
    CategoryResponse findCategory(long id) throws FindCategoryException;
    List<CategoryDto> getAllCategory();
    CategoryResponse deleteCategory(long id) throws DeleteCategoryException;
    CategoryDto updateCategory(long id, CategoryDto categoryDto);

}
