package org.example.Mapper;


import org.example.Model.Invoice;
import org.example.Model.Order;
import org.example.Service.OrderServicel;
import org.example.dto.Request.OrderRequest;
import org.example.dto.ProductMapDto;
import org.example.utils.ProductsMapHandler;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderRequestToOrder implements Function<OrderRequest, Order> {


    private final ProductsMapHandler ProductsMapHandler;


    public OrderRequestToOrder(org.example.utils.ProductsMapHandler productsMapHandler, OrderServicel service) {
        ProductsMapHandler = productsMapHandler;
        this.service = service;
    }

    @Override
    public Order apply(OrderRequest orderRequest) {
        ProductMapDto dto=ProductsMapHandler.MapToDto(orderRequest.productMap());
        Invoice invoice = service.GetById(orderRequest.);
        return Order.builder()
                .OrderId(orderRequest.OrderId())
                .invoice(orderRequest.invoice())
                .amount(orderRequest.amount())
                .customer(orderRequest.customer())
                .date(orderRequest.date())
                .dueDate(orderRequest.dueDate())
//                .productsMap_key(dto.keys())
//                .productsMap_value(dto.values())
                .build();
    }
}
