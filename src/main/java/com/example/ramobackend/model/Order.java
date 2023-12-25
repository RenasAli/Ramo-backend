package com.example.ramobackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_number", unique = true)
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
    @Column(name = "comment", length = 500)
    private String comment;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "vat")
    private double vat;

    @Column(name = "order_total_amount")
    private double orderTotalAmount;


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    public boolean getPaymentStatus() {
        return paymentStatus;
    }
}
