package com.example.ramobackend.controller;

import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.services.ProductItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/app/v1/api/category/products/items")
public class ProductItemController {
    ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductItem>> getAllProductItems(){
        return new ResponseEntity<>(productItemService.getAllProductItems(), HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<ProductItem>> getAllFilteredProductItems( @RequestParam(required = false) Long productId,
            @RequestParam(required = false) List<String>  brand, @RequestParam(required = false) List<String> color,
            @RequestParam(required = false) List<String> type, @RequestParam(required = false) List<String> serie,
            @RequestParam(required = false) List<Integer> hight, @RequestParam(required = false) List<Integer> width,
            @RequestParam(required = false) List<Integer> depth){

        return new ResponseEntity<>(productItemService.getAllFilteredProductItems(
                productId, brand, color, serie, type, hight, width, depth),
                HttpStatus.OK);
    }


    @GetMapping("/productItemNumber/{productItemNumber}")
    public ResponseEntity<ProductItem> getProductItemByProductItemNumber(
            @PathVariable("productItemNumber") Integer productItemNumber
                                                                         ){
        return new ResponseEntity<>(
                productItemService.getProductItemByProductItemNumber(productItemNumber), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem product){
        return new ResponseEntity<>(productItemService.createProductItem(product), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/{productItemId}")
    public ResponseEntity<ProductItem> editProductItemById(@PathVariable("productItemId") Long productItemId,
                                                   @RequestBody ProductItem productItem){
        return new ResponseEntity<>(productItemService.editProductItemsById(productItemId, productItem), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{productItemId}")
    public void deleteProductItemById(@PathVariable("productItemId") Long productItemId){
        productItemService.deleteProductItemById(productItemId);
    }


}
