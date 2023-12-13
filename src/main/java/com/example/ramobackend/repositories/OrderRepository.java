package com.example.ramobackend.repositories;

import com.example.ramobackend.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findOrderByOrderNumber(Integer orderNumber);
    boolean existsByOrderNumber(Integer orderNumber);
}
