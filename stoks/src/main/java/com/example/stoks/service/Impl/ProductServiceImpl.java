package com.example.stoks.service.Impl;


import com.example.stoks.dto.ProductDto;
import com.example.stoks.exception.productBaseException.CreateProductException;
import com.example.stoks.exception.productBaseException.DeleteProductException;
import com.example.stoks.exception.productBaseException.FindProductException;
import com.example.stoks.mapper.ProductMapper;
import com.example.stoks.model.Category;
import com.example.stoks.model.Product;
import com.example.stoks.repository.ProductRepository;
import com.example.stoks.response.Meta;
import com.example.stoks.response.ProductResponse;
import com.example.stoks.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final CategoryServiceImpl categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryServiceImpl categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }

    public List<ProductDto> getAllProduct() {
       List<ProductDto> productDtoList=new ArrayList<>();

       Iterable <Product> products=productRepository.findAll();
       for (Product product : products){

           ProductDto productDto=productMapper.toResource(product);
           productDtoList.add(productDto);

       }
        return productDtoList;
    }


    public ProductDto updateProduct(long id, ProductDto productDto) {

        Product productEntity=productMapper.toEntity(productDto);
        Product saveProduct=productRepository.findProductById(id);

        saveProduct.setProductName(productEntity.getProductName());
        saveProduct.setProductDescription(productEntity.getProductDescription());
        saveProduct.setProductAmount(productEntity.getProductAmount());

        Product updateProduct=productRepository.save(saveProduct);
        ProductDto dto=productMapper.toResource(updateProduct);
        return dto;
    }

    public ProductResponse addProduct(ProductDto productDto) throws CreateProductException {
        Product product = productMapper.toEntity(productDto);
        Category category = categoryService.findByCategoryId(productDto.categoryId);
        product.setCategory(category);
        product = productRepository.save(product);
        if (product != null) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.product = productMapper.toResource(product);
            productResponse.meta = new Meta(200, "Ürün eklendi ");
            return productResponse;
        } else {
            throw new CreateProductException();
        }
    }

    public ProductResponse deleteProduct(long id) throws DeleteProductException {
        Optional<Product> product=productRepository.findById(id);
        if (product.isPresent()){
            productRepository.deleteById(id);
            ProductResponse response=new ProductResponse();
            response.meta=new Meta(200,"Kullanıcı silindi");
            return response;
        }else {
            throw new DeleteProductException();
        }
    }

    public ProductResponse findProductByDto(long id) throws FindProductException {
        Product product=findProduct(id);
        if (product!=null){
            ProductResponse productResponse=new ProductResponse();
            productResponse.product=productMapper.toResource(product);
            productResponse.meta=new Meta(200,"Ürün bulundu");
            return productResponse;
        }else {
            throw new FindProductException();
        }
    }

    private Product findProduct(long id) {
        Product product=productRepository.findProductById(id);
        return product;
    }
}
