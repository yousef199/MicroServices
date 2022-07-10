package com.yousef.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName)
                .lastName(customerRegistrationRequest.lastName)
                .email(customerRegistrationRequest.email)
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster){
            throw new IllegalStateException("is fraudster customer");
        }
    }
}
