package com.yousef.customer;

import com.yousef.clients.fraud.FraudCheckResponse;
import com.yousef.clients.fraud.FraudClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName)
                .lastName(customerRegistrationRequest.lastName)
                .email(customerRegistrationRequest.email)
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse != null && fraudCheckResponse.getIsFraudster()){
            throw new IllegalStateException("is fraudster customer");
        }
        if(fraudCheckResponse != null && fraudCheckResponse.getIsFraudster()){
            throw new IllegalStateException("is fraudster customer");
        }
    }
}
