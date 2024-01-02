package com.example.ramobackend.controller;

import com.example.ramobackend.model.SubImages;
import com.example.ramobackend.services.SubImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/app/v1/api/category/products/items/subimages")
public class SubImagesController {
    SubImageService subImageService;

    public SubImagesController(SubImageService subImageService) {
        this.subImageService = subImageService;
    }

    @GetMapping()
    public ResponseEntity<List<SubImages>> getAlleSubImages(){
        return new ResponseEntity<>(subImageService.getAllSubImages(), HttpStatus.OK);
    }

    @GetMapping("/product-number/{productItemSubImageNumber}")
    public ResponseEntity<List<SubImages>> getAlleSubImagesByProductItemSubimageNumber(
            @PathVariable("productItemSubImageNumber") Integer productItemSubImageNumber){
        return new ResponseEntity<>(
                subImageService.getAlleSubImagesByProductItemSubImageNumber(productItemSubImageNumber), HttpStatus.OK);

    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{productItemId}")
    public ResponseEntity<SubImages> createSubImages(@PathVariable ("productItemId") Long productItemId,
            @RequestBody SubImages subimages){
        return new ResponseEntity<>(subImageService.createSubImages(subimages, productItemId), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{subImageId}")
    public void deleteSubImagesById(@PathVariable("subImageId") Long subImageId){
        subImageService.deleteSubImagesById(subImageId);
    }
}

