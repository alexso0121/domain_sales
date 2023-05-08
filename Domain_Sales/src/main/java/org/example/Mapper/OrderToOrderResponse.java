package org.example.Mapper;

import org.example.Model.Order;
import org.example.Model.Product;
import org.example.dto.OrderResponse;
import org.example.dto.ProductMapDto;
import org.example.utils.ProductsMapHandler;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public class OrderToOrderResponse implements Function<Order, OrderResponse> {
    private final ProductsMapHandler ProductsMapHandler;

    public OrderToOrderResponse(org.example.utils.ProductsMapHandler productsMapHandler) {
        ProductsMapHandler = productsMapHandler;
    }
    @Override
    public OrderResponse apply(Order order) {
        ProductMapDto dto=new ProductMapDto(order.getProductsMap_key(),order.getProductsMap_value());
        Map<Product,String> map= ProductsMapHandler.DtoToMap(dto);
        return new OrderResponse(
                order.getOrderId(),
                map,
                order.getAmount(),
                order.getDate(),
                order.getDueDate(),
                order.getInvoice(),
                order.getCustomer()
        );
    }
}
