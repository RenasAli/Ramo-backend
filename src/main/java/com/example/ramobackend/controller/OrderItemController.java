package com.example.ramobackend.controller;

import com.example.ramobackend.model.OrderItem;
import com.example.ramobackend.services.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/order/orderItem")
public class OrderItemController {
    OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public ResponseEntity<List<OrderItem>> getAlle(){
        return new ResponseEntity<>(orderItemService.getAlleOrderItems(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OrderItem> createOrderItem (@RequestBody OrderItem orderItem){
        return new ResponseEntity<>(orderItemService.createOrderItem(orderItem), HttpStatus.OK);
    }
}
