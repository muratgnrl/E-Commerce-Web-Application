package com.example.stoks.repository;

import com.example.stoks.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    Category findCategoryById(long categoryId);
}
