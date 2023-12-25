package com.example.ramobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "product_item")
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_item_number" , unique = true)
    private Integer productItemNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "url")
    private String url;

    @Column(name = "img")
    private String img;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "description", length = 5000)
    private String description;

    @Lob
    @Column(name = "product_item_info", length = 500)
    private String info;

    @Column(name = "serie")
    private String serie;

    @Column(name = "hight")
    private Integer hight;

    @Column(name = "width")
    private Integer width;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_type_name")
    private String productTypeName;
    @JsonBackReference(value = "product")
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;


    @JsonBackReference
    @OneToMany(mappedBy = "ProductItem")
    private List<SubImages> subImages= new ArrayList<>();

}
