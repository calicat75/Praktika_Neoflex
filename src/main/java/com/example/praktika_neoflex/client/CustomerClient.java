package com.example.praktika_neoflex.client;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class CustomerClient {

    public Map<String, Object> getCustomer(UUID customerId) {

        return Map.of(

                "id", customerId,

                "firstName", "John",

                "lastName", "Doe"

        );

    }

}