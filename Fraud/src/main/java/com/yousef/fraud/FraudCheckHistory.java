package com.yousef.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class FraudCheckHistory {
    @Id @SequenceGenerator(name = "fruad_id_sequence" , sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Integer id;
    private Integer customerID;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
