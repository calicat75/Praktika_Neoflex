package com.example.praktika_neoflex.dto.request;

import com.example.praktika_neoflex.enums.AccountStatus;

public record StatusHistoryRequest(

        AccountStatus oldStatus,

        AccountStatus newStatus,

        String reason,

        String changedBy

) {
}
