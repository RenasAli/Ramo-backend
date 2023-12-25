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

    public ProductsCategory getProductsCategoryById(Long id){
        return  productsCategoryRepository.findById(id).get();
    }

    public ProductsCategory createProductsCategory(ProductsCategory productsCategory){
        return productsCategoryRepository.save(productsCategory);
    }

    public  ProductsCategory editProductsCategoryById(Long productsCategoryId, ProductsCategory productsCategory){
        ProductsCategory editedProductsCategory = productsCategoryRepository.findById(productsCategoryId).get();

        if (productsCategory.getCategoryName() != null){editedProductsCategory.setCategoryName(productsCategory.getCategoryName());}
        if (productsCategory.getCategoryDescription() != null){editedProductsCategory.setCategoryDescription(productsCategory.getCategoryDescription());}
        if (productsCategory.getCategoryUrl() != null){editedProductsCategory.setCategoryUrl(productsCategory.getCategoryUrl());}
        if (productsCategory.getCategoryImg() != null){editedProductsCategory.setCategoryImg(productsCategory.getCategoryImg());}


        return productsCategoryRepository.save(editedProductsCategory);
    }
    public void deleteById(Long id){
        productsCategoryRepository.deleteById(id);
    }

}
