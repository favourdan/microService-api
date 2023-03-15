package com.favourscode.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController{

    private final CustomerService customerService;

    @PostMapping("")
    public void RegisterCustomer(@RequestBody CustomerRegistrationRequest customerRequest){
        log.info("customer created {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}
