package com.example.praktika_neoflex.dto.client;

import java.util.UUID;

public record CustomerDto(

        UUID id,

        String firstName,

        String lastName

) {}
