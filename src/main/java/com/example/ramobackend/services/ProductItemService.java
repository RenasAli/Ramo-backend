package com.example.ramobackend.services;

import com.example.ramobackend.model.Product;
import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.repositories.ProductItemRepository;
import com.example.ramobackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductItemService {
    ProductItemRepository productItemRepository;

    ProductRepository productRepository;

    @Autowired
    public ProductItemService(ProductItemRepository productItemRepository,  ProductRepository productRepository) {
        this.productItemRepository = productItemRepository;

        this.productRepository = productRepository;
    }

    public List<ProductItem> getAllProductItems(){
        return (List<ProductItem>) productItemRepository.findAll();
    }

    public List<ProductItem> getAllProductItemsByProductName( String productName){
        return (List<ProductItem>) productItemRepository.findAllByProductTypeName(productName);
    }

    public List<ProductItem> getAllFilteredProductItems(Long productId, List<String>  brand, List<String> color,
                                                        List<String> type, List<String> serie, List<Integer> hight,
                                                        List<Integer> width, List<Integer> depth){
        return productItemRepository.findAllWithFilters(productId, brand, color, serie, type, hight, width, depth);
    }

    public ProductItem getProductItemByProductItemNumber(Integer productItemNumber){
        return productItemRepository.findProductItemByProductItemNumber(productItemNumber);
    }

    public ProductItem createProductItem(ProductItem productItem){
        Product product = productRepository.findById(productItem.getProductId()).get();
        productItem.setProduct(product);
        productItem.setProductTypeName(product.getProductName());
        productItem.setProductItemNumber(generateUniqueProductItemNumber());
        return productItemRepository.save(productItem);
    }

    public  ProductItem editProductItemsById(Long productItemId, ProductItem productItem){
        ProductItem editedProductItem = productItemRepository.findById(productItemId).get();
        editedProductItem.setName(productItem.getName());
        editedProductItem.setBrand(productItem.getBrand());
        editedProductItem.setColor(productItem.getColor());
        editedProductItem.setUrl(productItem.getUrl());
        editedProductItem.setImg(productItem.getImg());
        editedProductItem.setPrice(productItem.getPrice());
        editedProductItem.setType(productItem.getType());
        editedProductItem.setDescription(productItem.getDescription());
        editedProductItem.setInfo(productItem.getInfo());
        editedProductItem.setSerie(productItem.getSerie());
        editedProductItem.setHight(productItem.getHight());
        editedProductItem.setWidth(productItem.getWidth());
        editedProductItem.setDepth(productItem.getDepth());
        editedProductItem.setProduct(productItem.getProduct());

        return productItemRepository.save(editedProductItem);
    }

    public void deleteProductItemById(Long productItemId){
        productItemRepository.deleteById(productItemId);
    }

    private int generateUniqueProductItemNumber(){
        Integer productItemNumber;
        do {
            productItemNumber =  (Integer)ThreadLocalRandom.current().nextInt(1001, 10001);
        }while (productItemRepository.existsByProductItemNumber(productItemNumber));
            return productItemNumber;
    }


}
