package com.example.praktika_neoflex.dto.request;

import com.example.praktika_neoflex.enums.OwnerType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountRequest(

        String accountNumber,

        UUID ownerId,

        OwnerType ownerType,

        UUID currencyId,

        UUID accountTypeId,

        BigDecimal balance

) {
}
