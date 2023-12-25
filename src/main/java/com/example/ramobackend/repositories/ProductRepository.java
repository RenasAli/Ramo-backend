package com.example.ramobackend.repositories;
import com.example.ramobackend.model.Product;
import com.example.ramobackend.model.ProductsCategory;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Long> {
}
