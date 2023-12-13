package com.example.ramobackend.services;

import com.example.ramobackend.model.Order;
import com.example.ramobackend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {
    OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    public List<Order> getAlleOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderByOrderNumber(Integer orderNumber ){
        return orderRepository.findOrderByOrderNumber(orderNumber);
    }

    public Order createOrder(Order order){
        LocalDate date = LocalDate.now();
        order.setOrderNumber(generateUniqueOrderNumber());
        order.setDate(date);
        return orderRepository.save(order);
    }

    public  Order editOrderById(Long orderId, Order order){
        Order editedOrder = orderRepository.findById(orderId).get();

        if (order.getCustomerCompanyName() != null){editedOrder.setCustomerCompanyName(order.getCustomerCompanyName());}
        if (order.getCustomerName() != null){editedOrder.setCustomerName(order.getCustomerName());}
        if (order.getCustomerEmail() != null){editedOrder.setCustomerEmail(order.getCustomerEmail());}
        if (order.getCustomerTlf() != null){editedOrder.setCustomerTlf(order.getCustomerTlf());}
        if (order.getAddress() != null){editedOrder.setAddress(order.getAddress());}
        if (order.getCity() != null){editedOrder.setCity(order.getCity());}
        if (order.getZipCode() != null){editedOrder.setZipCode(order.getZipCode());}
        if (order.getComment() != null){editedOrder.setComment(order.getComment());}
        if (order.getPaymentMethod() != null){editedOrder.setPaymentMethod(order.getPaymentMethod());}
        if (order.getPaymentStatus()){editedOrder.setPaymentStatus(order.getPaymentStatus());}
        if (order.getOrderStatus() != null){editedOrder.setOrderStatus(order.getOrderStatus());}

        return orderRepository.save(editedOrder);
    }

    private int generateUniqueOrderNumber(){
        Integer orderNumber;
        do {
            orderNumber =  (Integer) ThreadLocalRandom.current().nextInt(100);
        }while (orderRepository.existsByOrderNumber(orderNumber));
        return orderNumber;
    }
}
