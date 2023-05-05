package org.example.Service;

import org.example.Model.Customer;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.dto.CustomerRequest;
import org.example.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CustomerServiceI extends SimpleCrudI<CustomerResponse,CustomerRequest> {


    public ResponseEntity<Set<Order>> GetOrders(UUID CustomerId);
}
