package com.example.ramobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "products_category")
public class ProductsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "products_category_name")
    private String categoryName;

    @Column(name = "products_category_description")
    private String categoryDescription;

    @Column(name = "products_category_url")
    private String categoryUrl;

    @Column(name = "products_category_img")
    private String categoryImg;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;


}
