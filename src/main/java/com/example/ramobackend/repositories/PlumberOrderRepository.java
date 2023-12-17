package com.example.ramobackend.repositories;

import com.example.ramobackend.model.PlumberOrder;
import org.springframework.data.repository.CrudRepository;

public interface PlumberOrderRepository extends CrudRepository<PlumberOrder, Long> {
    PlumberOrder findPlumberOrderByOrderNumber(Integer orderNumber);

    boolean existsByOrderNumber(Integer orderNumber);
}
