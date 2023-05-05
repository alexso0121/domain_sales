package org.example.dto;

import org.example.Model.Customer;
import org.example.Model.Invoice;
import org.example.Model.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public record OrderRequest (

        UUID OrderId,

        Map<Product,String> productMap,
        double amount,
        LocalDate date,
        LocalDate dueDate,
        Invoice invoice,
        Customer customer


){}
