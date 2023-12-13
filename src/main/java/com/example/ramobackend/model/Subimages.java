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
public class Subimages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subiamge_url")
    private String subimageUrl;

    @Column(name = "product_item_subimage_nr")
    private Integer  productItemSubimageNumber;

    @Column(name = "product_item_id")
    private Long productItemId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_item")
    private ProductItem ProductItem;

}
