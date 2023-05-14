package org.example.Service;

import org.example.Model.Order;
import org.example.dto.Request.CustomerRequest;
import org.example.dto.Response.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;
import java.util.UUID;

public interface CustomerServiceI extends SimpleCrudI<CustomerResponse,CustomerRequest> {


    public ResponseEntity<Set<Order>> GetOrders(UUID CustomerId);
}
