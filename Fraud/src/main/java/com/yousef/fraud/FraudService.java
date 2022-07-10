package com.yousef.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {
    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudRepository.save(FraudCheckHistory.builder()
                .customerID(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
