package com.stackabuse.microservices.customerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/customer")
public class CustomerServiceController {

    @GetMapping(value = "/{customerId}")
    public String address(@PathVariable(name = "customerId", required = true) long customerId){
        log.info("GET /customer/{}", customerId);
        return String.format("Customer details of id %s", customerId);
    }
}
