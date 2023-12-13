package com.example.ramobackend.repositories;

import com.example.ramobackend.model.ProductsCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductsCategoryRepository extends CrudRepository<ProductsCategory,Long> {
    ProductsCategory findProductsCategoryByCategoryName(String name);
}
