package com.example.ramobackend.controller;

import com.example.ramobackend.model.Product;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
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

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable("productId") Long productId){
        productService.deleteProductById(productId);
    }
}
