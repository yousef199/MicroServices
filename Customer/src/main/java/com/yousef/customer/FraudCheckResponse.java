package com.yousef.customer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
public class FraudCheckResponse {
    Boolean isFraudster;

    @JsonCreator
    public FraudCheckResponse(@JsonProperty("isFraudster") Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
