//package org.example.Service.ServiceImpl;
//
//import lombok.NonNull;
//import org.example.Exception.ApiException.OrderNotFoundException;
//import org.example.Model.Order;
//import org.example.Repository.OrderRepository;
//import org.example.Service.OrderServicel;
//import org.example.dto.OrderResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class OrderServiceImpl implements OrderServicel {
//
//
//
//    private final OrderRepository repository;
//
//    public OrderServiceImpl(OrderRepository orderRepository) {
//        this.repository = orderRepository;
//    }
//
//    @Override
//    public ResponseEntity<OrderResponse> GetById(@NonNull UUID Id) {
//        return new ResponseEntity<>(repository.findById(Id)
//                .orElseThrow(()->new OrderNotFoundException("No Order With UUID: "+Id))
//                , HttpStatus.ACCEPTED);
//    }
//
//    @Override
//    public ResponseEntity<String> Add(List<Order> request) {
//        try{
//            repository.saveAll(
//                    request
//            );
//            return new ResponseEntity<>("successfully added",HttpStatus.ACCEPTED);
//        } catch (Exception exception){
//            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @Override
//    public ResponseEntity<String> Update(Order request) {
//        try{
//            Order oldOrder = repository.findById(request.getOrderId())
//                    .orElseThrow(()->new OrderNotFoundException("No Order found"));
//           oldOrder.setAmount(request.getAmount());
//           oldOrder.setCustomer(request.getCustomer());
//           oldOrder.setInvoice(request.getInvoice());
//           oldOrder.setDate(request.getDate());
//           oldOrder.setProducts(request.getProducts());
//           repository.save(oldOrder);
//            return new ResponseEntity<>("update success",HttpStatus.ACCEPTED);
//        }catch(Exception exception){
//            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//    @Override
//    public ResponseEntity<String> Delete(UUID Id) {
//        try{
//            repository.deleteById(Id);
//            return new ResponseEntity<>("delete successful",HttpStatus.ACCEPTED);
//        }catch (Exception exception){
//            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @Override
//    public ResponseEntity<List<Order>> Query() {
//        return new ResponseEntity<>(repository.findAll(),HttpStatus.ACCEPTED);
//    }
//
//
//}
