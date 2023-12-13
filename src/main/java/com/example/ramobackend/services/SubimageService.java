package com.example.ramobackend.services;

import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.model.Subimages;
import com.example.ramobackend.repositories.ProductItemRepository;
import com.example.ramobackend.repositories.SubimageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubimageService {
    SubimageRepository subimageRepository;
    ProductItemRepository productItemRepository;

    public SubimageService(SubimageRepository subimageRepository, ProductItemRepository productItemRepository) {
        this.subimageRepository = subimageRepository;
        this.productItemRepository = productItemRepository;
    }

    public List<Subimages> getAllSubimages(){
    return (List<Subimages>) subimageRepository.findAll();
    }

    public List<Subimages> getAlleSubImagesByProductItemSubimageNumber( Integer productItemSubimageNumber){
        return (List<Subimages>) subimageRepository.findSubimagesByProductItemSubimageNumber(productItemSubimageNumber);
    }

    public Subimages createSubimages(Subimages subimages, Long productItemId){
        ProductItem productItem = productItemRepository.findById(productItemId).get();
        subimages.setProductItem(productItem);
        subimages.setProductItemSubimageNumber(productItem.getProductItemNumber());
        return subimageRepository.save(subimages);
    }

    public void deleteSubimagesById(Long subimagesId){
        subimageRepository.deleteById(subimagesId);
    }
}
