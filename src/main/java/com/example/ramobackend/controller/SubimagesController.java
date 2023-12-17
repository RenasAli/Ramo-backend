package com.example.ramobackend.controller;

import com.example.ramobackend.model.Subimages;
import com.example.ramobackend.services.SubimageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category/products/items/subimages")
public class SubimagesController {
    SubimageService subimageService;

    public SubimagesController(SubimageService subimageService) {
        this.subimageService = subimageService;
    }

    @GetMapping()
    public ResponseEntity<List<Subimages>> getAlleSubimages(){
        return new ResponseEntity<>(subimageService.getAllSubimages(), HttpStatus.OK);
    }

    @GetMapping("/product-number/{productItemSubimageNumber}")
    public ResponseEntity<List<Subimages>> getAlleSubimagesByProductItemSubimageNumber(
            @PathVariable("productItemSubimageNumber") Integer productItemSubimageNumber){
        return new ResponseEntity<>(
                subimageService.getAlleSubImagesByProductItemSubimageNumber(productItemSubimageNumber), HttpStatus.OK);

    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{productItemId}")
    public ResponseEntity<Subimages> createSubImages(@PathVariable ("productItemId") Long productItemId,
            @RequestBody Subimages subimages){
        return new ResponseEntity<>(subimageService.createSubimages(subimages, productItemId), HttpStatus.OK);
    }
}

