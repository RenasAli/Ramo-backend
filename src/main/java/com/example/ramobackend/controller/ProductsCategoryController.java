package com.example.ramobackend.controller;

import com.example.ramobackend.model.ProductsCategory;
import com.example.ramobackend.services.ProductsCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/app/v1/api/category")
public class ProductsCategoryController {
    ProductsCategoryService productsCategoryService;

    public ProductsCategoryController(ProductsCategoryService productsCategoryService) {
        this.productsCategoryService = productsCategoryService;
    }


    @GetMapping()
    public ResponseEntity<List<ProductsCategory>> getAllProductsCategories(){
        return new ResponseEntity<>(productsCategoryService.getAllProductsCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ProductsCategory> getProductsCategoryById(@PathVariable("categoryId") Long categoryId){
        return new ResponseEntity<>(productsCategoryService.getProductsCategoryById(categoryId), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public ResponseEntity<ProductsCategory> createProductsCategory(@RequestBody ProductsCategory productsCategory){
        return new ResponseEntity<>(productsCategoryService.createProductsCategory(productsCategory), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/{categoryId}")
    public ResponseEntity<ProductsCategory> editProductsCategoryById(@PathVariable("categoryId") Long categoryId,
                                                                     @RequestBody ProductsCategory productsCategory){
        return new ResponseEntity<>(productsCategoryService.editProductsCategoryById(categoryId, productsCategory), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{productCategoryId}")
    public void deleteById(@PathVariable("productCategoryId") Long productCategoryId){
        productsCategoryService.deleteById(productCategoryId);
    }

}
