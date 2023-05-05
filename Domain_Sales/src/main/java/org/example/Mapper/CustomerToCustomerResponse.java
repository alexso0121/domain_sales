package org.example.Mapper;

import org.example.Model.Customer;
import org.example.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerToCustomerResponse implements Function<Customer, CustomerResponse> {

    @Override
    public CustomerResponse apply(Customer customer) {
        return new CustomerResponse(    
                customer.getCustomerId(),customer.getName(),customer.getContactEmail()
                ,customer.getContactNumber(), customer.getCompany(), customer.getCompanyAddress(),customer.getOrders());
    }
}
