package com.example.ramobackend.services;

import com.example.ramobackend.model.Order;
import com.example.ramobackend.model.OrderItem;
import com.example.ramobackend.model.ProductItem;
import com.example.ramobackend.repositories.OrderItemRepository;
import com.example.ramobackend.repositories.OrderRepository;
import com.example.ramobackend.repositories.ProductItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    OrderItemRepository orderItemRepository;
    ProductItemRepository productItemRepository;
    OrderRepository orderRepository;

    public OrderItemService(OrderItemRepository orderItemRepository, ProductItemRepository productItemRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productItemRepository = productItemRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderItem> getAlleOrderItems (){
        return (List<OrderItem>) orderItemRepository.findAll();
    }
    public OrderItem createOrderItem(OrderItem orderItem){
        ProductItem productItem = productItemRepository.findById(orderItem.getProductItemId()).get();
        Order order = orderRepository.findById(orderItem.getOrderId()).get();
        orderItem.setOrder(order);
        orderItem.setProductItem(productItem);
        orderItem.setOrderItemNumber(productItem.getProductItemNumber());
        orderItem.setOrderItemTitle(productItem.getName());
        orderItem.setOrderItemPrice(productItem.getPrice());
        double totalAmount = productItem.getPrice() * orderItem.getOrderItemQuantity();
        orderItem.setOrderItemTotalPrice(totalAmount);
        return orderItemRepository.save(orderItem);
    }
}
