package com.example.praktika_neoflex.dto.response;

import com.example.praktika_neoflex.dto.client.CustomerDto;
import com.example.praktika_neoflex.dto.client.LoanDto;
import com.example.praktika_neoflex.dto.client.TransactionDto;

import java.util.List;

public record AccountDetailsResponse(

        AccountResponse account,

        CustomerDto customer,

        List<LoanDto> loans,

        List<TransactionDto> transactions

) {
}