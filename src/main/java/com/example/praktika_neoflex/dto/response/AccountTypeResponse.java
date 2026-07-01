package com.example.praktika_neoflex.dto.response;

import java.util.UUID;

public record AccountTypeResponse(

        UUID id,

        String name,

        String description

) {
}
