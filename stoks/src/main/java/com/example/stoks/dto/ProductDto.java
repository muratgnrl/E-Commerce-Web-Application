package com.example.stoks.dto;


import lombok.Builder;
import lombok.Data;

import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
@Log4j2
@Data
@Builder
public class ProductDto implements Serializable {

    public long id;
    public String productName;
    public String productDescription;
    public int productAmount;
    public long categoryId;
}
