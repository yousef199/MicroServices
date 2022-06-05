package com.yousef.customer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
