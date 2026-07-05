package com.example.praktika_neoflex.controller;

import com.example.praktika_neoflex.dto.client.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/stub/customers")
public class CustomerStubController {

    @GetMapping("/{id}")
    public CustomerDto getCustomer(
            @PathVariable UUID id
    ) {

        return new CustomerDto(

                id,

                null,

                null

        );

    }

}