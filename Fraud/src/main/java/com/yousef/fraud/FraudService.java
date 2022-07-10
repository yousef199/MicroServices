package com.yousef.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        boolean fraud = false;
        fraudRepository.save(FraudCheckHistory.builder()
                .customerID(customerId)
                .isFraudster(fraud)
                .createdAt(LocalDateTime.now())
                .build());
        return fraud;
    }
}
