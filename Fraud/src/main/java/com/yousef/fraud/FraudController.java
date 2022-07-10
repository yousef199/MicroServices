package com.yousef.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor @Slf4j
public class FraudController {
    private  final FraudService fraudService;
    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
         boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
         log.info("Fraud Check Response for customer {}" , customerId);
         return new FraudCheckResponse(isFraudulentCustomer);
    }
}
