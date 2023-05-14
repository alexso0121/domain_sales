package org.example.dto.Response;

import org.example.Model.Invoice;
import org.example.Model.Order;

import java.util.UUID;

public record InvoiceResponse(
        UUID InvoiceId,

        double price,
        Invoice.PaymentType paymentType,
        Order order,
        String paymentNote,
        String SelfNote
) {
}
