package org.example.Service.ServiceImpl;

import lombok.NonNull;
import org.example.Exception.ApiException.OrderNotFoundException;
import org.example.Mapper.OrderRequestToOrder;
import org.example.Mapper.OrderToOrderResponse;
import org.example.Model.Order;
import org.example.Repository.OrderRepository;
import org.example.Service.OrderServicel;
import org.example.dto.Request.OrderRequest;
import org.example.dto.Response.OrderResponse;
import org.example.utils.ProductsMapHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderServicel {



    private final OrderRepository repository;
    private final OrderRequestToOrder orderRequestToOrder;

    private final OrderToOrderResponse orderToOrderResponse;
    private final ProductsMapHandler productsMapHandler;


    public OrderServiceImpl(OrderRepository orderRepository, OrderRequestToOrder orderRequestToOrder, OrderToOrderResponse orderToOrderResponse, ProductsMapHandler productsMapHandler) {
        this.repository = orderRepository;
        this.orderRequestToOrder = orderRequestToOrder;
        this.orderToOrderResponse = orderToOrderResponse;
        this.productsMapHandler = productsMapHandler;
    }

    @Override
    public ResponseEntity<OrderResponse> GetById(@NonNull UUID Id) {
        return new ResponseEntity<>(repository.findById(Id)
                .map(orderToOrderResponse)
                .orElseThrow(()->new OrderNotFoundException("No Order With UUID: "+Id))
                , HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> Add(List<OrderRequest> request) {
        try{
            repository.saveAll(
                    request.stream().map(orderRequestToOrder).collect(java.util.stream.Collectors.toList()
            ));
            return new ResponseEntity<>("successfully added",HttpStatus.ACCEPTED);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> Update(OrderRequest request) {
        try{
            Order oldOrder = repository.findById(request.OrderId())
                    .orElseThrow(()->new OrderNotFoundException("No Order found"));
           oldOrder.setAmount(request.amount());
           oldOrder.setCustomer(request.customer());
           oldOrder.setInvoice(request.invoice());
           oldOrder.setDate(request.date());
           oldOrder.setDueDate(request.dueDate());
           oldOrder.setProductsMap_key(productsMapHandler.MapToDto(request.productMap()).keys());
           oldOrder.setProductsMap_value(productsMapHandler.MapToDto(request.productMap()).values());
           repository.save(oldOrder);
            return new ResponseEntity<>("update success",HttpStatus.ACCEPTED);
        }catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> Delete(UUID Id) {
        try{
            repository.deleteById(Id);
            return new ResponseEntity<>("delete successful",HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<OrderResponse>> Query() {
        return new ResponseEntity<>(repository.findAll()
                .stream().map(orderToOrderResponse)
                .collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }



}
