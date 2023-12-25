package com.example.ramobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "subimages")
public class SubImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subimage_url")
    private String subImageUrl;

    @Column(name = "product_item_subimage_nr")
    private Integer  productItemSubImageNumber;

    @Column(name = "product_item_id")
    private Long productItemId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_item")
    private ProductItem ProductItem;

}
