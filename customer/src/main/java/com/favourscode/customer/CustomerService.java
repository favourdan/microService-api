package com.favourscode.customer;

import com.favourscode.customer.Customer;
import com.favourscode.customer.CustomerRegistrationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;



    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();
        //SaveAndFlush to get customers id
         customerRepository.saveAndFlush(customer);
         // connecting to fraud using its server name ....localhost:8083 to FRAUD
         FraudCheckResponse checkResponse = restTemplate.getForObject(
                 "http://FRAUD/api/v1/fraud/{customerId}",
                FraudCheckResponse.class,customer.getId()
         );
         if(checkResponse.isFraudster()){
             throw new IllegalArgumentException("fraudster gang");
         }

    }
}
