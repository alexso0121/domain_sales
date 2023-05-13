package org.example.Controller;

import org.example.Service.CustomerServiceI;
import org.example.Service.ServiceImpl.CustomerServiceImpl;
import org.example.dto.CustomerRequest;
import org.example.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/Customer")
public class CustomerContoller {
    private final CustomerServiceI customerService;

    public CustomerContoller(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{CustomerId}")
    public ResponseEntity<CustomerResponse> GetCustomerByUId(@PathVariable UUID CustomerId){
        return customerService.GetById(CustomerId);
    }

    @PostMapping("/Add")
    public ResponseEntity<String> Add(@RequestBody List<CustomerRequest> request){
        return customerService.Add(request);
    }

    @PostMapping("/Update")
    public ResponseEntity<String> Update(@RequestBody CustomerRequest request){
        return customerService.Update(request);
    }

    @DeleteMapping("/Delete/{Id}")
    public ResponseEntity<String> Delete(@PathVariable UUID Id){
        return customerService.Delete(Id);
    }


    @GetMapping("/Query")
    public ResponseEntity<List<CustomerResponse>> Query(){
        return customerService.Query();
    }







}
