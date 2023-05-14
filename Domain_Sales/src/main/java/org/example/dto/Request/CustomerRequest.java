package org.example.dto.Request;

import jakarta.annotation.Nullable;
import org.example.Model.Order;

import java.util.Set;
import java.util.UUID;

public record CustomerRequest(
        UUID CustomerId,
        String Name,
        String ContactEmail,
        String ContactNumber,
        String Company,
        String CompanyAddress,
        @Nullable Set<Order> orders
) {
}
