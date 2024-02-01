package com.example.stoks.controller;

import com.example.stoks.dto.ProductDto;
import com.example.stoks.exception.productBaseException.CreateProductException;
import com.example.stoks.exception.productBaseException.DeleteProductException;
import com.example.stoks.exception.productBaseException.FindProductException;
import com.example.stoks.response.ProductResponse;
import com.example.stoks.service.Impl.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProduct")
    public List<ProductDto> getAllProduct(){
        List<ProductDto> productDtoList=productService.getAllProduct();
        return productDtoList;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable (value = "id") long id ,@RequestBody ProductDto productDto ) {

        return  ResponseEntity.ok(productService.updateProduct(id,productDto));
    }
    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductDto productDto) throws CreateProductException {
        ProductResponse productResponse=productService.addProduct(productDto);
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable(value = "id") long id) throws DeleteProductException {
        ProductResponse productResponse= productService.deleteProduct(id);
        return ResponseEntity.ok(productResponse);
    }
    @GetMapping("/findProduct/{id}")
    public ResponseEntity<ProductResponse> findProduct(@PathVariable(value = "id") long id) throws FindProductException {
        ProductResponse response=productService.findProductByDto(id);
        return ResponseEntity.ok(response);
    }
}
