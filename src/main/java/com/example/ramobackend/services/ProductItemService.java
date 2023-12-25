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
        if(productItem.getName() != null){editedProductItem.setName(productItem.getName());}
        if(productItem.getBrand() != null){editedProductItem.setBrand(productItem.getBrand());}
        if(productItem.getColor() != null){editedProductItem.setColor(productItem.getColor());}
        if(productItem.getUrl() != null){editedProductItem.setUrl(productItem.getUrl());}
        if(productItem.getImg() != null){editedProductItem.setImg(productItem.getImg());}
        if(productItem.getPrice() != 0){editedProductItem.setPrice(productItem.getPrice());}
        if(productItem.getType() != null){editedProductItem.setType(productItem.getType());}
        if(productItem.getDescription() != null){
            editedProductItem.setDescription(productItem.getDescription());}
        if(productItem.getInfo() != null){editedProductItem.setInfo(productItem.getInfo());}
        if(productItem.getSerie() != null){editedProductItem.setSerie(productItem.getSerie());}
        if(productItem.getHight() != null){editedProductItem.setHight(productItem.getHight());}
        if(productItem.getWidth() != null){editedProductItem.setWidth(productItem.getWidth());}
        if(productItem.getDepth() != null){editedProductItem.setDepth(productItem.getDepth());}

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
