package com.yousef.clients.fraud;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FraudCheckResponse {
    Boolean isFraudster;

    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
