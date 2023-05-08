package org.example.Controller;


import org.example.Service.ServiceImpl.OrderServiceImpl;
import org.example.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<OrderResponse> findById(UUID id){


    }
}
