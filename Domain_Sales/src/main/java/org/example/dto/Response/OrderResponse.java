package org.example.dto.Response;

import org.example.Model.Customer;
import org.example.Model.Invoice;
import org.example.Model.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record OrderResponse(
        UUID OrderId,

        Map<Product,String> productMap,
        double amount,
        LocalDate date,
        LocalDate dueDate,
        Invoice invoice,
        Customer customer

) {
}

