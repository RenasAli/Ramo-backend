package com.example.ramobackend.controller;

import com.example.ramobackend.model.SubImages;
import com.example.ramobackend.services.SubImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category/products/items/subimages")
public class SubImagesController {
    SubImageService subimageService;

    public SubImagesController(SubImageService subimageService) {
        this.subimageService = subimageService;
    }

    @GetMapping()
    public ResponseEntity<List<SubImages>> getAlleSubImages(){
        return new ResponseEntity<>(subimageService.getAllSubImages(), HttpStatus.OK);
    }

    @GetMapping("/product-number/{productItemSubImageNumber}")
    public ResponseEntity<List<SubImages>> getAlleSubImagesByProductItemSubimageNumber(
            @PathVariable("productItemSubImageNumber") Integer productItemSubImageNumber){
        return new ResponseEntity<>(
                subimageService.getAlleSubImagesByProductItemSubImageNumber(productItemSubImageNumber), HttpStatus.OK);

    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{productItemId}")
    public ResponseEntity<SubImages> createSubImages(@PathVariable ("productItemId") Long productItemId,
            @RequestBody SubImages subimages){
        return new ResponseEntity<>(subimageService.createSubImages(subimages, productItemId), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{subImagesId}")
    public void deleteSubImagesById(@PathVariable("subImagesId") Long subImagesId){
        subimageService.deleteSubImagesById(subImagesId);
    }
}

