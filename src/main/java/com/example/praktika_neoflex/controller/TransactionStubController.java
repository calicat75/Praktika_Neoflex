package com.example.praktika_neoflex.controller;

import com.example.praktika_neoflex.dto.client.TransactionDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/stub/transactions")
public class TransactionStubController {

    @GetMapping("/account/{accountId}")
    public List<TransactionDto> getTransactions(
            @PathVariable UUID accountId
    ) {

        return Collections.emptyList();

    }

}