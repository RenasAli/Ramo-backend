package com.example.ramobackend.testServices;

import com.example.ramobackend.model.PlumberOrder;
import com.example.ramobackend.repositories.PlumberOrderRepository;
import com.example.ramobackend.services.PlumberOrderService;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class plumberOrderTestService {

    @Autowired
    private PlumberOrderService plumberOrderService;
    @Autowired
    private PlumberOrderRepository plumberOrderRepository;
    private Long createdId;







    @Test
    @Order(1)
    @DisplayName("Create New PlumberOrder")
    @BeforeEach
    public void testCreatePlumberOrder(){
        PlumberOrder plumberOrder = new PlumberOrder();
        LocalDate date = LocalDate.now();
        plumberOrder.setCustomerName("test customer");
        plumberOrder.setCustomerEmail("test@email.dk");
        plumberOrder.setCustomerTlf("42 42 42 43");
        plumberOrder.setAddress("testvej 212 ");
        plumberOrder.setCity("testby");
        plumberOrder.setZipCode(4242);
        plumberOrder.setDate(date);
        plumberOrder.setDescription("test to test");
        plumberOrder.setOrderNumber(100);

        PlumberOrder createdPlumberOrder = plumberOrderService.createPlumberOrder(plumberOrder);
        setCreatedId(createdPlumberOrder.getOrderId());
        System.out.println("the id is " + createdId);
        assertNotNull(createdPlumberOrder.getOrderId());
    }

    @Test
    @Order(2)
    @DisplayName("Display Alle PlumberOrders")
    public void testDisplayPlumberOrders(){
        List<PlumberOrder> plumberOrders = plumberOrderService.getAllePlumberOrders();
        assertNotNull(plumberOrders);
    }
    @Test
    @Order(3)
    @DisplayName("Update PlumberOrder By Id")
    public void  testUpdatePlumberOrderById(){
        PlumberOrder plumberOrder = new PlumberOrder();

        plumberOrder.setCustomerName("updated test customer");
        plumberOrder.setCustomerEmail("updated test@email.dk");
        plumberOrder.setCustomerTlf("44 44 44 43");
        plumberOrder.setAddress("updatedtestvej 212 ");
        plumberOrder.setCity(" updated testby");
        plumberOrder.setZipCode(4444);
        plumberOrder.setDescription("updated test to test");
        PlumberOrder updatedPlumberOrder = plumberOrderService.editPlumberOrderById(getCreatedId(),plumberOrder);
        assertEquals("updated test customer", updatedPlumberOrder.getCustomerName());

    }

    @Test
    @Order(4)
    @DisplayName("Delete PlumberOrder By Id")
    public void  testDeletePlumberOrderById(){
        plumberOrderRepository.deleteById(getCreatedId());
    }


}
