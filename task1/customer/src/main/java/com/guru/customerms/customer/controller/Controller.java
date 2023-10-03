package com.guru.customerms.customer.controller;

import com.guru.customerms.customer.model.CustomerDto;
import com.guru.customerms.customer.service.CustomerService;
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
}
