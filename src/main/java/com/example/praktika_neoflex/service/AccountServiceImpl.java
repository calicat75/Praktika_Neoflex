package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.client.CustomerClient;
import com.example.praktika_neoflex.client.LoanClient;
import com.example.praktika_neoflex.client.TransactionClient;
import com.example.praktika_neoflex.dto.client.CustomerDto;
import com.example.praktika_neoflex.dto.client.LoanDto;
import com.example.praktika_neoflex.dto.client.TransactionDto;
import com.example.praktika_neoflex.dto.response.AccountDetailsResponse;
import com.example.praktika_neoflex.dto.response.AccountResponse;
import com.example.praktika_neoflex.entity.Account;
import com.example.praktika_neoflex.exception.AccountNotFoundException;
import com.example.praktika_neoflex.mapper.AccountMapper;
import com.example.praktika_neoflex.repository.AccountRepository;
import com.example.praktika_neoflex.repository.AccountStatusHistoryRepository;
import com.example.praktika_neoflex.dto.request.ChangeAccountStatusRequest;
import com.example.praktika_neoflex.entity.AccountStatusHistory;
import com.example.praktika_neoflex.repository.AccountStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper mapper;

    private final CustomerClient customerClient;

    private final LoanClient loanClient;

    private final TransactionClient transactionClient;

    private final AccountStatusHistoryRepository historyRepository;

    @Override
    public List<AccountResponse> getAllAccounts() {

        return mapper.toResponseList(
                accountRepository.findAllWithHistory()
        );

    }

    @Override
    public AccountResponse getAccountById(UUID id) {

        Account account = accountRepository.findByIdWithHistory(id)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found: " + id
                        ));

        return mapper.toResponse(account);

    }

    @Override
    public List<AccountResponse> getAccountsByCustomer(UUID customerId) {

        return mapper.toResponseList(
                accountRepository.findByOwnerIdWithHistory(customerId)
        );

    }

    @Override
    public AccountDetailsResponse getAccountDetails(UUID id) {

        Account account = accountRepository.findByIdWithHistory(id)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found: " + id
                        ));

        AccountResponse accountResponse = mapper.toResponse(account);

        CustomerDto customer =
                customerClient.getCustomer(account.getOwnerId());

        List<LoanDto> loans =
                loanClient.getLoans(account.getOwnerId());

        List<TransactionDto> transactions =
                transactionClient.getTransactions(account.getId());

        return new AccountDetailsResponse(

                accountResponse,

                customer,

                loans,

                transactions

        );

    }

    @Override
    public CustomerDto getCustomerStatus(UUID customerId) {

        return customerClient.getCustomer(customerId);

    }

    @Override
    public AccountResponse changeAccountStatus(
            UUID accountId,
            ChangeAccountStatusRequest request
    ) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException(
                                "Account not found: " + accountId
                        ));

        AccountStatusHistory history =
                AccountStatusHistory.builder()
                        .id(UUID.randomUUID())
                        .account(account)
                        .oldStatus(account.getAccountStatus())
                        .newStatus(request.getStatus())
                        .reason(request.getReason())
                        .changedBy("system")
                        .build();

        historyRepository.save(history);

        account.setAccountStatus(request.getStatus());

        accountRepository.save(account);

        return mapper.toResponse(account);

    }

}