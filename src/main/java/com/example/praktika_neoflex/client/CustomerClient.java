package com.example.praktika_neoflex.client;

import com.example.praktika_neoflex.dto.client.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerClient {

    private final RestTemplate restTemplate;

    private static final String URL =
            "http://clients-service/api/customers/";

    public CustomerDto getCustomer(UUID customerId) {

        return restTemplate.getForObject(

                URL + customerId,

                CustomerDto.class

        );

    }

}