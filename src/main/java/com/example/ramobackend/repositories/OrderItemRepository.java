package com.example.ramobackend.repositories;

import com.example.ramobackend.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
