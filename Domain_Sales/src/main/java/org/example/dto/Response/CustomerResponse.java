package org.example.dto.Response;

import org.example.Model.Order;

import java.util.Set;
import java.util.UUID;


public record CustomerResponse(
        UUID CustomerId,
        String Name,
        String ContactEmail,
        String ContactNumber,
        String Company,
        String CompanyAddress,
        Set<Order> orders

) {}
