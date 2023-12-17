package com.example.ramobackend.controller;

import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.services.ProductItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category/products/items")
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

    @GetMapping("/{productName}")
    public ResponseEntity<List<ProductItem>> getAllProductItemsByProductName(
            @PathVariable("productName") String productName){
        return new ResponseEntity<>(productItemService.getAllProductItemsByProductName(productName), HttpStatus.OK);
    }
    @GetMapping("/productItemNumber/{productItemNumber}")
    public ResponseEntity<ProductItem> getProductItemByProductItemNumber(@PathVariable("productItemNumber") Integer productItemNumber
                                                                         ){
        return new ResponseEntity<>(productItemService.getProductItemByProductItemNumber(productItemNumber), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping()
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem product){
        return new ResponseEntity<>(productItemService.createProductItem(product), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/{ProductItemId}")
    public ResponseEntity<ProductItem> editProductItemById(@PathVariable("ProductItemId") Long ProductItemId,
                                                   @RequestBody ProductItem productItem){
        return new ResponseEntity<>(productItemService.editProductItemsById(ProductItemId, productItem), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{ProductItemId}")
    public void deleteProductItemById(@PathVariable("ProductItemId") Long ProductItemId){
        productItemService.deleteProductItemById(ProductItemId);
    }


}
