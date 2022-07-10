package com.yousef.clients.fraud;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FraudCheckResponse {
    Boolean isFraudster;


    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
