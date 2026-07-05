package com.example.praktika_neoflex.controller;

import com.example.praktika_neoflex.dto.client.LoanDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stub/loans")
public class LoanStubController {

    @GetMapping("/customer/{customerId}")
    public List<LoanDto> getLoans(
            @PathVariable UUID customerId
    ) {

        return Collections.emptyList();

    }

}