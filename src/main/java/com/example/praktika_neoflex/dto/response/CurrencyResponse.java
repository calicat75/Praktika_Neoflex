package com.example.praktika_neoflex.dto.response;


import java.util.UUID;

public record CurrencyResponse(

        UUID id,

        String code,

        String name,

        String symbol

) {
}
