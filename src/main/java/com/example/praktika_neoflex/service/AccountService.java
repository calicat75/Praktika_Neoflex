package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.dto.client.CustomerDto;
import com.example.praktika_neoflex.dto.request.ChangeAccountStatusRequest;
import com.example.praktika_neoflex.dto.response.AccountDetailsResponse;
import com.example.praktika_neoflex.dto.response.AccountResponse;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    List<AccountResponse> getAllAccounts();

    AccountResponse getAccountById(UUID id);

    List<AccountResponse> getAccountsByCustomer(UUID customerId);

    AccountDetailsResponse getAccountDetails(UUID id);

    CustomerDto getCustomerStatus(UUID customerId);

    AccountResponse changeAccountStatus(
            UUID accountId,
            ChangeAccountStatusRequest request
    );

}