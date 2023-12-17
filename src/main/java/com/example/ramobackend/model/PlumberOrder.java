package com.example.ramobackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "plumber_order")
public class PlumberOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_number")
    private Integer orderNumber;

    @Column(name = "customer_company_name")
    private String customerCompanyName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_tlf")
    private String customerTlf;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_Code")
    private Integer zipCode;

    @Lob
    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date")
    private LocalDate date;


}
