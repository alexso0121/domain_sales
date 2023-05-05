package org.example.Mapper;


import org.example.Model.Order;
import org.example.dto.OrderRequest;
import org.example.dto.ProductMapDto;
import org.example.utils.ProductsMapHandler;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderRequestToOrder implements Function<OrderRequest, Order> {


    @Override
    public Order apply(OrderRequest orderRequest) {
        ProductMapDto dto=ProductsMapHandler.MapToDto(orderRequest.productMap());
        return Order.builder()
                .OrderId(orderRequest.OrderId())
                .invoice(orderRequest.invoice())
                .amount(orderRequest.amount())
                .customer(orderRequest.customer())
                .build();
    }
}
