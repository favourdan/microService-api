package com.favourscode.fraud;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {
    private final FraudCheckRepository fraudCheckRepository;

    public boolean isFraudulentCustomer(Integer customerId){

      FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
              .isFraudster(false)
              .customerId(customerId)
              .createdAt(LocalDateTime.now())
              .build();
      fraudCheckRepository.save(fraudCheckHistory);
       return false;

    }

}
