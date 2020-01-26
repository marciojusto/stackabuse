package com.stackabuse.microservices.portalservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class PortalServiceController {

    @GetMapping(value = "/fullDetails/{customerId}")
    public String address(@PathVariable(name = "customerId", required = true) long customerId) {

        log.info("GET /fullDetails/{}", customerId);

        RestTemplate restTemplate = new RestTemplate();
        String customerResponse =
                restTemplate.getForObject("http://localhost:8060/customer-service/customer/" + customerId, String.class);
        String addressResponse =
                restTemplate.getForObject("http://localhost:8060/address-service/address/" + customerId, String.class);

        return String.format(customerResponse + "<br>" + addressResponse);
    }
}
