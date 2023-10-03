package com.guru.customerms.customer.service;

import com.guru.customerms.customer.model.CustomerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Log4j2
@Service
public class CustomerService {

    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder()
                .clientId(customerId)
                .name("Leroy Jenkins")
                .build();
    }

    public CustomerDto createCustomer(CustomerDto customerDTO) {
        return CustomerDto.builder()
                .clientId(UUID.randomUUID())
                .name(customerDTO.getName())
                .build();
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDTO) {
        //todo implement later
    }

    public void deleteCustomerById(UUID customerId) {
        log.info("Deleating customer ...");
    }
}
