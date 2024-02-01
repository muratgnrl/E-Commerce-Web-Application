package com.example.stoks.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
@Builder
@Log4j2
@Entity
@Table(name = "Ürün")
public class Product extends BaseEntity implements Serializable {

    @Column(name = "Ürün_adı", nullable = false)
    private String productName;
    @Column(name = "Ürün_açıklaması", nullable = false)
    private String productDescription;
    @Column(name = "Ürün_fiyatı" , nullable = false)
    private int productAmount;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(String productName, String productDescription, int productAmount, Category category) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productAmount = productAmount;
        this.category = category;
    }
}
