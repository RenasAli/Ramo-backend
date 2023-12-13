package com.example.ramobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_item_number")
    private Integer orderItemNumber;

    @Column(name = "order_item_title")
    private String orderItemTitle;

    @Column(name = "order_item_price")
    private double orderItemPrice;

    @Column(name = "order_item_quantity")
    private Integer orderItemQuantity;

    @Column(name = "order_item_total_price")
    private double orderItemTotalPrice;

    @Column(name = "item_id")
    private Long productItemId;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_item_id", nullable = true)
    private ProductItem productItem;
    @JsonBackReference(value = "order")
    @ManyToOne
    @JoinColumn(name = "`order`")
    private Order order;
}
