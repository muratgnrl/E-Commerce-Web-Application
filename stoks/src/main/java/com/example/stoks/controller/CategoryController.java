package com.example.stoks.controller;

import com.example.stoks.dto.CategoryDto;
import com.example.stoks.exception.categoryBaseException.CreateCategoryException;
import com.example.stoks.exception.categoryBaseException.DeleteCategoryException;
import com.example.stoks.exception.categoryBaseException.FindCategoryException;
import com.example.stoks.response.CategoryResponse;
import com.example.stoks.service.Impl.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl service;

    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryDto categoryDto) throws CreateCategoryException {
        CategoryResponse response=service.addCategory(categoryDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findCategory/{id}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable(value = "id") long id) throws FindCategoryException {
        CategoryResponse categoryResponse=service.findCategory(id);
        return ResponseEntity.ok(categoryResponse);
    }
    @GetMapping("/getAllCategory")
    public List<CategoryDto> getAllCategory(){
        List<CategoryDto> categoryDtoList=service.getAllCategory();
        return categoryDtoList;
    }
    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable(value = "id") long id,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(service.updateCategory(id,categoryDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable (value = "id") long id) throws DeleteCategoryException {
        CategoryResponse categoryResponse=service.deleteCategory(id);
        return ResponseEntity.ok(categoryResponse);
    }
}
