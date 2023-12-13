package com.example.ramobackend.model;

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
@Table(name = "toilet")
public class Toilet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toilet_id")
    private Long toiletId;

    @Column(name = "toilet_name")
    private String toiletName;

    @Column(name = "toilet_brand")
    private String toiletBrand;

    @Column(name = "toilet_description")
    private String toiletDescription;

    @Column(name = "toilet_price")
    private double toiletPrice;

    @Column(name = "toilet_color")
    private String toiletColor;

    @Column(name = "toilet_type")
    private String toiletType;





}
