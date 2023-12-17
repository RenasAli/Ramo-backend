package com.example.ramobackend.controller;

import com.example.ramobackend.model.PlumberOrder;
import com.example.ramobackend.services.PlumberOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/plumber")
public class PlumberOrderController {
    PlumberOrderService plumberOrderService;

    public PlumberOrderController(PlumberOrderService plumberOrderService) {
        this.plumberOrderService = plumberOrderService;
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public ResponseEntity<List<PlumberOrder>> getAllPlumberOrders(){
        return new ResponseEntity<>(plumberOrderService.getAllePlumberOrders(), HttpStatus.OK);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/order-number/{orderNumber}")
    public ResponseEntity<PlumberOrder> getPlumberOrderByOrderNumber(@PathVariable("orderNumber") Integer orderNumber){
        return new ResponseEntity<>(plumberOrderService.getPlumberOrderByOrderNumber(orderNumber), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PlumberOrder> createPlumberOrder(@RequestBody PlumberOrder plumberOrder){
        return new ResponseEntity<>(plumberOrderService.createPlumberOrder(plumberOrder), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/{orderId}")
    public ResponseEntity<PlumberOrder> editPlumberOrderById(@PathVariable("orderId") Long orderId, @RequestBody PlumberOrder plumberOrder){
        return new ResponseEntity<>(plumberOrderService.editPlumberOrderById(orderId, plumberOrder), HttpStatus.OK);
    }
}
