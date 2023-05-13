package org.example.Controller;


import org.example.Service.ServiceImpl.OrderServiceImpl;
import org.example.dto.OrderRequest;
import org.example.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Order")
public class OrderController {
    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(UUID id){
        return orderService.GetById(id);
    }

    @GetMapping("/Query")
    public ResponseEntity<List<OrderResponse>> Query(){
        return orderService.Query();
    }

    @PostMapping("/Add")
    public ResponseEntity<String> Add(@RequestBody List<OrderRequest> request){
        return orderService.Add(request);

    }

    @PostMapping("/Update")
    public ResponseEntity<String> Update(@RequestBody OrderRequest request){
        return orderService.Update(request);
    }

    @DeleteMapping("/Delete/{Id}")
    public ResponseEntity<String> Delete(@PathVariable UUID Id){
        return orderService.Delete(Id);
    }



}
