package com.example.ramobackend.controller;

import com.example.ramobackend.model.ProductsCategory;
import com.example.ramobackend.services.ProductsCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class ProductsCategoryController {
    ProductsCategoryService productsCategoryService;

    public ProductsCategoryController(ProductsCategoryService productsCategoryService) {
        this.productsCategoryService = productsCategoryService;
    }

    @GetMapping()
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ProductsCategory>> getAllProductsCategories(){
        return new ResponseEntity<>(productsCategoryService.getAllProductsCategories(), HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<ProductsCategory> getAllProductsCategoryByName(@PathVariable("categoryName") String categoryName){
        return new ResponseEntity<>(productsCategoryService.getProductsCategoryByName(categoryName), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductsCategory> createProductsCategory(@RequestBody ProductsCategory productsCategory){
        return new ResponseEntity<>(productsCategoryService.createProductsCategory(productsCategory), HttpStatus.OK);
    }

    @PatchMapping("/{categoryId}")
    public ResponseEntity<ProductsCategory> editProductsCategoryById(@PathVariable("categoryId") Long categoryId,
                                                                     @RequestBody ProductsCategory productsCategory){
        return new ResponseEntity<>(productsCategoryService.editProductsCategoryById(categoryId, productsCategory), HttpStatus.OK);
    }


}
