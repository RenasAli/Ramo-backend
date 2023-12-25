package com.example.ramobackend.services;

import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.model.SubImages;
import com.example.ramobackend.repositories.ProductItemRepository;
import com.example.ramobackend.repositories.SubImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubImageService {
    SubImageRepository subImageRepository;
    ProductItemRepository productItemRepository;

    public SubImageService(SubImageRepository subimageRepository, ProductItemRepository productItemRepository) {
        this.subImageRepository = subimageRepository;
        this.productItemRepository = productItemRepository;
    }

    public List<SubImages> getAllSubImages(){
    return (List<SubImages>) subImageRepository.findAll();
    }

    public List<SubImages> getAlleSubImagesByProductItemSubImageNumber( Integer productItemSubImageNumber){
        return (List<SubImages>) subImageRepository.findSubImagesByProductItemSubImageNumber(productItemSubImageNumber);
    }

    public SubImages createSubImages(SubImages subImages, Long productItemId){
        ProductItem productItem = productItemRepository.findById(productItemId).get();
        subImages.setProductItem(productItem);
        subImages.setProductItemSubImageNumber(productItem.getProductItemNumber());
        return subImageRepository.save(subImages);
    }

    public void deleteSubImagesById(Long subImagesId){
        subImageRepository.deleteById(subImagesId);
    }
}
