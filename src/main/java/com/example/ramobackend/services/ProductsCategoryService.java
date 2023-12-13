package com.example.ramobackend.services;

import com.example.ramobackend.model.ProductsCategory;
import com.example.ramobackend.repositories.ProductsCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsCategoryService {
    ProductsCategoryRepository productsCategoryRepository;

    public ProductsCategoryService(ProductsCategoryRepository productsCategoryRepository) {
        this.productsCategoryRepository = productsCategoryRepository;
    }

    public List<ProductsCategory> getAllProductsCategories(){
        return (List<ProductsCategory>) productsCategoryRepository.findAll();
    }

    public ProductsCategory getProductsCategoryByName(String name){
        return productsCategoryRepository.findProductsCategoryByCategoryName(name);
    }

    public ProductsCategory createProductsCategory(ProductsCategory productsCategory){
        return productsCategoryRepository.save(productsCategory);
    }

    public  ProductsCategory editProductsCategoryById(Long productsCategoryId, ProductsCategory productsCategory){
        ProductsCategory editedProductsCategory = productsCategoryRepository.findById(productsCategoryId).get();

        editedProductsCategory.setCategoryName(productsCategory.getCategoryName());
        editedProductsCategory.setCategoryDescription(productsCategory.getCategoryDescription());
        editedProductsCategory.setCategoryUrl(productsCategory.getCategoryUrl());
        editedProductsCategory.setCategoryImg(productsCategory.getCategoryImg());

        return productsCategoryRepository.save(editedProductsCategory);
    }

}
