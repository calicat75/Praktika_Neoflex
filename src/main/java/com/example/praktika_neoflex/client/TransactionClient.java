package com.example.praktika_neoflex.client;

import com.example.praktika_neoflex.dto.client.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransactionClient {

    private final RestTemplate restTemplate;

    private static final String URL =
            "http://clients-service:8084/api/transactions/account/";

    public List<TransactionDto> getTransactions(UUID accountId) {

        return restTemplate.exchange(

                URL + accountId,

                org.springframework.http.HttpMethod.GET,

                null,

                new ParameterizedTypeReference<List<TransactionDto>>() {}

        ).getBody();

    }

}