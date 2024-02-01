package com.example.stoks.exception;

import com.example.stoks.exception.categoryBaseException.CreateCategoryException;
import com.example.stoks.exception.categoryBaseException.DeleteCategoryException;
import com.example.stoks.exception.categoryBaseException.FindCategoryException;
import com.example.stoks.exception.productBaseException.CreateProductException;
import com.example.stoks.exception.productBaseException.DeleteProductException;
import com.example.stoks.exception.productBaseException.FindProductException;
import com.example.stoks.response.CategoryResponse;
import com.example.stoks.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> createCategoryException(CreateCategoryException createCategoryException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4001;
        meta.errorDescription="Kategori eklenemedi";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findCategoryException(FindCategoryException findCategoryException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4004;
        meta.errorDescription="Kategori bulunamadı";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteCategory(DeleteCategoryException deleteCategoryException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4007;
        meta.errorDescription="Kategori silinemedi";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> productAddException(CreateProductException createProductException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4020;
        meta.errorDescription="Ürün eklenemedi ";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> deleteExceptionProduct(DeleteProductException deleteProductException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4021;
        meta.errorDescription="Ürün silinemedi";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }   @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> findProductException(FindProductException findProductException , WebRequest webRequest){
        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        meta.errorCode=4010;
        meta.errorDescription="Ürün bulunamadı ";
        categoryResponse.meta=meta;

        ResponseEntity<Object> entity=new ResponseEntity<>(categoryResponse , HttpStatus.NOT_FOUND);
        return entity;

    }
}
