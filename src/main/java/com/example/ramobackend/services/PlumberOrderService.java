package com.example.ramobackend.services;

import com.example.ramobackend.model.PlumberOrder;
import com.example.ramobackend.repositories.PlumberOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PlumberOrderService {
    PlumberOrderRepository plumberOrderRepository;

    public PlumberOrderService(PlumberOrderRepository plumberOrderRepository) {
        this.plumberOrderRepository = plumberOrderRepository;
    }
    public List<PlumberOrder> getAllePlumberOrders(){
        return (List<PlumberOrder>) plumberOrderRepository.findAll();
    }

    public PlumberOrder getPlumberOrderByOrderNumber(Integer orderNumber){
        return plumberOrderRepository.findPlumberOrderByOrderNumber(orderNumber);
    }

    public PlumberOrder createPlumberOrder(PlumberOrder plumberOrder){
        LocalDate date = LocalDate.now();
        plumberOrder.setDate(date);
        plumberOrder.setOrderNumber(generateUniqueOrderNumber());
        return plumberOrderRepository.save(plumberOrder);
    }

    public PlumberOrder editPlumberOrderById(Long orderId, PlumberOrder plumberOrder){
        PlumberOrder editedOrder = plumberOrderRepository.findById(orderId).get();

        if (plumberOrder.getCustomerCompanyName() != null){editedOrder.setCustomerCompanyName(plumberOrder.getCustomerCompanyName());}
        if (plumberOrder.getCustomerName() != null){editedOrder.setCustomerName(plumberOrder.getCustomerName());}
        if (plumberOrder.getCustomerEmail() != null){editedOrder.setCustomerEmail(plumberOrder.getCustomerEmail());}
        if (plumberOrder.getCustomerTlf() != null){editedOrder.setCustomerTlf(plumberOrder.getCustomerTlf());}
        if (plumberOrder.getAddress() != null){editedOrder.setAddress(plumberOrder.getAddress());}
        if (plumberOrder.getCity() != null){editedOrder.setCity(plumberOrder.getCity());}
        if (plumberOrder.getZipCode() != null){editedOrder.setZipCode(plumberOrder.getZipCode());}
        if (plumberOrder.getDescription() != null){editedOrder.setDescription(plumberOrder.getDescription());}
        if (plumberOrder.getOrderStatus() != null){editedOrder.setOrderStatus(plumberOrder.getOrderStatus());}

        return plumberOrderRepository.save(editedOrder);
    }

    private int generateUniqueOrderNumber(){
        Integer orderNumber;
        do {
            orderNumber =  (Integer) ThreadLocalRandom.current().nextInt(10000) + 100;
        }while (plumberOrderRepository.existsByOrderNumber(orderNumber));
        return orderNumber;
    }
}
