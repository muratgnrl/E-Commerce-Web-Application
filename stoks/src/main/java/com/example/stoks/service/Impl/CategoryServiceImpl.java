package com.example.stoks.service.Impl;

import com.example.stoks.dto.CategoryDto;
import com.example.stoks.exception.categoryBaseException.CreateCategoryException;
import com.example.stoks.exception.categoryBaseException.DeleteCategoryException;
import com.example.stoks.exception.categoryBaseException.FindCategoryException;
import com.example.stoks.mapper.CategoryMapper;
import com.example.stoks.model.Category;
import com.example.stoks.repository.CategoryRepository;
import com.example.stoks.response.CategoryResponse;
import com.example.stoks.response.Meta;
import com.example.stoks.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponse addCategory(CategoryDto categoryDto) throws CreateCategoryException {
        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepository.save(category);
        if (category != null) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.category = categoryMapper.toResource(category);
            categoryResponse.meta = new Meta(200, "Kategori eklendi");
            return categoryResponse;
        } else {
            throw new CreateCategoryException();
        }
    }

    public CategoryResponse findCategory(long id) throws FindCategoryException {
        Category category=findByCategoryId(id);
        if (category!=null){
            CategoryResponse categoryResponse=new CategoryResponse();
            categoryResponse.category=categoryMapper.toResource(category);
            categoryResponse.meta=new Meta(200,"Kategori bulundu");
            return categoryResponse;
        }else {
            throw new FindCategoryException();
        }
    }

    public Category findByCategoryId(long id) {
        Category category=categoryRepository.findCategoryById(id);
        return category;
    }

    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> categoryDtoList=new ArrayList<>();

        Iterable<Category> categories=categoryRepository.findAll();
        for (Category category: categories){

            CategoryDto categoryDto=categoryMapper.toResource(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    public CategoryDto updateCategory(long id, CategoryDto categoryDto) {
        Category category=categoryMapper.toEntity(categoryDto);
        Category categories=categoryRepository.findCategoryById(id);

        categories.setCategoryName(category.getCategoryName());
        categories.setCategoryDescription(category.getCategoryDescription());

        Category updateCategory=categoryRepository.save(categories);
        CategoryDto dto=categoryMapper.toResource(updateCategory);
        return dto;
    }

    public CategoryResponse deleteCategory(long id) throws DeleteCategoryException{
        Optional<Category> category=categoryRepository.findById(id);
        if (category.isPresent()){
            categoryRepository.deleteById(id);
            CategoryResponse categoryResponse=new CategoryResponse();
            categoryResponse.meta=new Meta(200,"Kategori silindi : " + id);
            return categoryResponse;
        }else {
            throw new DeleteCategoryException();
        }
    }
}
