package com.example.stoks.service;

import com.example.stoks.dto.ProductDto;
import com.example.stoks.exception.productBaseException.CreateProductException;
import com.example.stoks.exception.productBaseException.DeleteProductException;
import com.example.stoks.exception.productBaseException.FindProductException;
import com.example.stoks.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProduct();
    ProductDto updateProduct(long id, ProductDto productDto);
    ProductResponse addProduct(ProductDto productDto) throws CreateProductException;
    ProductResponse deleteProduct(long id) throws DeleteProductException;
    ProductResponse findProductByDto(long id) throws FindProductException;
}
