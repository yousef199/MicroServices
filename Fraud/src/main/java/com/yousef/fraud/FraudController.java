package com.yousef.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fruad-check")
@RequiredArgsConstructor
public class FraudController {
    @Autowired
    private  final FraudService fraudService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
         boolean isFraudulentCustomer = fraudService.isFraudulentCustomer(customerId);
         return new FraudCheckResponse(isFraudulentCustomer);
    }
}
