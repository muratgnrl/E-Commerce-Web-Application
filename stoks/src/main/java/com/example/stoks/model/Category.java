package com.example.stoks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.List;

@Log4j2
@Entity
@Table(name = "Kategori")
@Builder
public class Category extends BaseEntity implements Serializable {

    @Column(name = "kategori_adı",unique = true)
    private String categoryName;
    @Column(name = "Kategori_açıklaması",nullable = false)
    private String categoryDescription;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Category(String categoryName, String categoryDescription, List<Product> productList) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.productList = productList;
    }

    public Category() {
    }
}
