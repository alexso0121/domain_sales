package org.example.Mapper;

import org.example.Model.Customer;
import org.example.dto.CustomerRequest;
import org.example.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class CustomerRequestToCustomer implements Function<CustomerRequest, Customer> {

    @Override
    public Customer apply(CustomerRequest customer) {
        return new Customer(
                customer.CustomerId(),customer.Name(),customer.ContactEmail()
                ,customer.ContactNumber(), customer.Company(), customer.CompanyAddress(),null);
    }
}
