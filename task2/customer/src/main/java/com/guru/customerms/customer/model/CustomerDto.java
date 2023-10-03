package com.guru.customerms.customer.model;

import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private UUID clientId;
    private String name;
}
