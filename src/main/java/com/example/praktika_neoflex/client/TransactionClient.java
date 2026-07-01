package com.example.praktika_neoflex.client;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class TransactionClient {

    public List<Map<String, Object>> getTransactions(UUID accountId) {

        return List.of(

                Map.of(

                        "transactionId", UUID.randomUUID(),

                        "amount", 5000

                )

        );

    }

}
