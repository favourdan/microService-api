package com.favourscode.fraud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/fraud")
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable ("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}" , customerId);
        return new FraudCheckResponse(isFraudulentCustomer);

    }

}
