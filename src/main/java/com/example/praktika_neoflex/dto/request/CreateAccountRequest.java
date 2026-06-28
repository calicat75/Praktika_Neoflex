package com.example.praktika_neoflex.dto.request;

import com.example.praktika_neoflex.enums.AccountType;
import com.example.praktika_neoflex.enums.OwnerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateAccountRequest(

        @NotNull
        UUID ownerId,

        @NotNull
        OwnerType ownerType,

        @NotNull
        AccountType accountType,

        @NotBlank
        String currencyCode,

        BigDecimal initialBalance

) {
}
