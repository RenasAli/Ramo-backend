package com.example.ramobackend.controller;

import com.example.ramobackend.model.Order;
import com.example.ramobackend.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAlleOrders(){
        return new ResponseEntity<>(orderService.getAlleOrders(), HttpStatus.OK);
    }
    @GetMapping("/order-number/{orderNumber}")
    public ResponseEntity<Order> getOrderByOrderNumber(@PathVariable("orderNumber") Integer orderNumber){
        return new ResponseEntity<>(orderService.getOrderByOrderNumber(orderNumber), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Order> editOrderById(@PathVariable("orderId") Long orderId, @RequestBody Order order){
        return new ResponseEntity<>(orderService.editOrderById(orderId, order), HttpStatus.OK);

    }


}
