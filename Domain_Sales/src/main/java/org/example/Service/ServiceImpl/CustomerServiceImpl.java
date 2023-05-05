package org.example.Service.ServiceImpl;

import lombok.NonNull;
import org.example.Exception.ApiException.CustomerNotFoundException;
import org.example.Mapper.CustomerRequestToCustomer;
import org.example.Mapper.CustomerToCustomerResponse;
import org.example.Model.Customer;
import org.example.Model.Order;
import org.example.Repository.CustomerRepository;
import org.example.Service.CustomerServiceI;
import org.example.dto.CustomerRequest;
import org.example.dto.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerServiceI {
    private final CustomerRepository customerRepository;
    private final CustomerToCustomerResponse customerToCustomerResponse;

    private final CustomerRequestToCustomer customerRequestToCustomer;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerToCustomerResponse customerToCustomerResponse, CustomerRequestToCustomer customerRequestToCustomer) {
        this.customerRepository = customerRepository;
        this.customerToCustomerResponse = customerToCustomerResponse;
        this.customerRequestToCustomer = customerRequestToCustomer;
    }


    public ResponseEntity<CustomerResponse> GetById(UUID CustomerId){

        return new ResponseEntity<>(customerRepository.findById(CustomerId).map(
                customerToCustomerResponse
                )
                .orElseThrow(
                ()->new CustomerNotFoundException("No Customer With UUID: "+CustomerId)), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> Add(@NonNull List<CustomerRequest> customer) {
        try{
         customerRepository.saveAll(
                customer.stream().map(customerRequestToCustomer).collect(Collectors.toList())
         );
         return new ResponseEntity<>("successfully added",HttpStatus.ACCEPTED);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> Update(CustomerRequest customer) {
        try{
            Customer oldcustomer =customerRepository.findById(customer.CustomerId())
                    .orElseThrow(()->new CustomerNotFoundException("No Customer founf"));
            oldcustomer.setName(customer.Name());
            oldcustomer.setCompany(customer.Company());
            oldcustomer.setContactEmail(customer.ContactEmail());
            oldcustomer.setCompanyAddress(customer.CompanyAddress());
            oldcustomer.setContactNumber(customer.ContactNumber());
            oldcustomer.setOrders(customer.orders());
            customerRepository.save(oldcustomer);
            return new ResponseEntity<>("update success",HttpStatus.ACCEPTED);
        }catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> Delete(UUID CustomerId) {
        try{
            customerRepository.deleteById(CustomerId);
            return new ResponseEntity<>("delete successful",HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<CustomerResponse>> Query() {
        return new ResponseEntity<>(customerRepository.findAll().stream().map(
                        customerToCustomerResponse
                ).collect(Collectors.toList()), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Set<Order>> GetOrders(UUID CustomerId) {
        return new ResponseEntity<>(customerRepository.findById(CustomerId).map(
                        customerToCustomerResponse
                )
                .orElseThrow(
                        ()->new CustomerNotFoundException("No Customer With UUID: "+CustomerId)).orders(), HttpStatus.ACCEPTED);
    }


}
