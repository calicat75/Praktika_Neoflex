package com.example.praktika_neoflex.dto.response;

import com.example.praktika_neoflex.enums.AccountStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record StatusHistoryResponse(

        UUID id,

        AccountStatus oldStatus,

        AccountStatus newStatus,

        String reason,

        String changedBy,

        LocalDateTime changedAt

) {
}
