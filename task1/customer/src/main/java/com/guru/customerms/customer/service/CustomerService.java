package com.guru.customerms.customer.service;

import com.guru.customerms.customer.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder()
                .clientId(customerId)
                .name("Leroy Jenkins")
                .build();
    }
}
