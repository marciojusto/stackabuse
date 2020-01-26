package com.stackabuse.microservices.addressservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/address")
public class AddressServiceController {

    @GetMapping(value = "/{customerId}")
    public String address(@PathVariable(name = "customerId", required = true) long customerId) {
        log.info("GET /address/{}", customerId);
        return String.format("Address of id %s", customerId);
    }
}
