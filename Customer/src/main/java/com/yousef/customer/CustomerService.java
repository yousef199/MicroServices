package com.yousef.customer;

import com.yousef.amqp.RabbitMQMessageProducer;
import com.yousef.clients.fraud.FraudCheckResponse;
import com.yousef.clients.fraud.FraudClient;
import com.yousef.clients.notification.NotificationClient;
import com.yousef.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.MBeanServerDelegate;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
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
        NotificationRequest notificationRequest =
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to my app",
                                customer.getFirstName())
                );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
