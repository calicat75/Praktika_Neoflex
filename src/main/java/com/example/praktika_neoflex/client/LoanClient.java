package com.example.praktika_neoflex.client;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class LoanClient {

    public List<Map<String, Object>> getLoans(UUID customerId) {

        return List.of(

                Map.of(

                        "loanId", UUID.randomUUID(),

                        "amount", 100000

                )

        );

    }

}
