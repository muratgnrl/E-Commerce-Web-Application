package com.example.stoks.response;

import com.example.stoks.dto.ProductDto;

import java.io.Serializable;

public class ProductResponse extends BaseResponse implements Serializable {
    public ProductDto product;
}
