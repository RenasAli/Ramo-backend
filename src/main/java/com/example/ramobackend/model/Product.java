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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;


    @Column(name = "product_url")
    private String ProductUrl;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_category_name")
    private String productCategoryName;

    @Column(name = "product_category_id")
    private Long categoryId;
    @ManyToOne
    @JsonBackReference(value = "product_category")
    @JoinColumn(name = "product_category")
    private ProductsCategory  productCategory;

    @OneToMany(mappedBy = "product")
    private List<ProductItem> productItems;

}
