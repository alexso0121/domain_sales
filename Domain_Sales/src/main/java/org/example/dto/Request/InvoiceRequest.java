package org.example.dto.Request;

import org.example.Model.Invoice;

import java.util.UUID;

public record InvoiceRequest(

        UUID InvoiceId,
        double price,
        Invoice.PaymentType paymentType,
        String orderId,
        String paymentNote


) {
}
