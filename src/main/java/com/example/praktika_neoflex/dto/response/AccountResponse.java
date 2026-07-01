package com.example.praktika_neoflex.dto.response;

import com.example.praktika_neoflex.enums.AccountStatus;
import com.example.praktika_neoflex.enums.OwnerType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record AccountResponse(

        UUID id,

        String accountNumber,

        UUID ownerId,

        OwnerType ownerType,

        CurrencyResponse currency,

        AccountTypeResponse accountType,

        BigDecimal balance,

        AccountStatus accountStatus,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        String createdBy,

        String updatedBy,

        Long version,

        List<StatusHistoryResponse> history

) {
}
