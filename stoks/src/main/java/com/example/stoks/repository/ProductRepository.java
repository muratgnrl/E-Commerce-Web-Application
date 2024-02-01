package com.example.stoks.repository;

import com.example.stoks.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductById(long id);
}
