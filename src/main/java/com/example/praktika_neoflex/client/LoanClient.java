package com.example.praktika_neoflex.client;

import com.example.praktika_neoflex.dto.client.LoanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoanClient {

    private final RestTemplate restTemplate;

    private static final String URL =
            "http://localhost:8083/api/loans/customer/";

    public List<LoanDto> getLoans(UUID customerId) {

        return restTemplate.exchange(

                URL + customerId,

                org.springframework.http.HttpMethod.GET,

                null,

                new ParameterizedTypeReference<List<LoanDto>>() {}

        ).getBody();

    }

}