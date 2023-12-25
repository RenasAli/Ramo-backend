package com.example.ramobackend.services;

import com.example.ramobackend.model.Product;
import com.example.ramobackend.model.ProductsCategory;
import com.example.ramobackend.repositories.ProductRepository;
import com.example.ramobackend.repositories.ProductsCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    ProductsCategoryRepository productsCategoryRepository;

    public ProductService(ProductRepository productRepository, ProductsCategoryRepository productsCategoryRepository) {
        this.productRepository = productRepository;
        this.productsCategoryRepository = productsCategoryRepository;
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }


    public Product createProduct(Product product){
        ProductsCategory category = productsCategoryRepository.findById(product.getCategoryId()).get();
        product.setProductCategory(category);
        product.setProductCategoryName(category.getCategoryName());
        return productRepository.save(product);
    }

    public Product editProductById(Long productId, Product product){
        Product editedProduct = productRepository.findById(productId).get();
        if (product.getProductName() != null){editedProduct.setProductName(product.getProductName());}
        if (product.getProductUrl() != null){editedProduct.setProductUrl(product.getProductUrl());}
        if (product.getProductImg() != null){editedProduct.setProductImg(product.getProductImg());}
        if (product.getProductDescription() != null){editedProduct.setProductDescription(product.getProductDescription());}

        return productRepository.save(editedProduct);
    }

    public void deleteProductById(Long productId){
        productRepository.deleteById(productId);
    }
}
