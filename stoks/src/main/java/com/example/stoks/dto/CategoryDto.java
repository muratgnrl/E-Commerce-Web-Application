package com.example.stoks.dto;

import com.example.stoks.model.Product;
import lombok.Builder;
import lombok.Data;

import lombok.extern.log4j.Log4j2;


import java.io.Serializable;
import java.util.List;
@Log4j2
@Data
@Builder
public class CategoryDto implements Serializable {

    public long id;
    public String categoryName;
    public String categoryDescription;
    public List<Product> productList;

}
