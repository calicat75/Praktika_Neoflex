package com.example.praktika_neoflex.dto.client;

import java.math.BigDecimal;
import java.util.UUID;

public record LoanDto(

        UUID id,

        UUID accountId,

        BigDecimal amount

) {}
