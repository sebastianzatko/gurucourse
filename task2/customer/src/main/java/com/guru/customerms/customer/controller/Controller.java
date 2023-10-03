package com.guru.customerms.customer.controller;

import com.guru.customerms.customer.model.CustomerDto;
import com.guru.customerms.customer.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/api/v1/customer")
@RestController
public class Controller {

    private final CustomerService customerService;

    public Controller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<CustomerDto>(customerService.getCustomer(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDTO){
        CustomerDto newCustomer=customerService.createCustomer(customerDTO);
        HttpHeaders headers=new HttpHeaders();
        headers.add("Location","/api/v1/customer"+newCustomer.getClientId().toString());
        return new ResponseEntity(headers,HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDTO){
        customerService.updateCustomer(customerId,customerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }

}
