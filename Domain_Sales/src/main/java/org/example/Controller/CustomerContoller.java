package org.example.Controller;

import org.example.Service.CustomerServiceI;
import org.example.Service.ServiceImpl.CustomerServiceImpl;
import org.example.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/Customer")
public class CustomerContoller {
    private final CustomerServiceI customerService;

    public CustomerContoller(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{CustomerId}")
    public ResponseEntity<CustomerResponse> GetCustomerByUId(@PathVariable UUID CustomerId){
        return customerService.GetById(CustomerId);
    }





}
