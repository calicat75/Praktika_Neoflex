package com.example.praktika_neoflex.dto.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDto(

        UUID id,

        UUID accountId,

        BigDecimal amount,

        LocalDateTime createdAt

) {
}