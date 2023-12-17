package com.example.ramobackend.controller;

import com.example.ramobackend.model.Product;
import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.model.ProductsCategory;
import com.example.ramobackend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getAllProductsByCategoryName(@PathVariable("categoryName") ProductsCategory category){
        return new ResponseEntity<>(productService.getAllProductsByProductsCategory(category), HttpStatus.OK);
    }

    @GetMapping("/product-name/{productName}")
    public ResponseEntity<Product> getProductsByyName(@PathVariable("productName") String productName){
        return new ResponseEntity<>(productService.getProductByName(productName), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/{ProductId}")
    public ResponseEntity<Product> editProductById(@PathVariable("ProductId") Long ProductId,
                                                   @RequestBody Product product){
        return new ResponseEntity<>(productService.editProductById(ProductId, product), HttpStatus.OK);
    }
}
