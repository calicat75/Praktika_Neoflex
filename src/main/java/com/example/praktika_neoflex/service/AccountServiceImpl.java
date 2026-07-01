package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.dto.response.AccountResponse;
import com.example.praktika_neoflex.entity.Account;
import com.example.praktika_neoflex.exception.AccountNotFoundException;
import com.example.praktika_neoflex.mapper.AccountMapper;
import com.example.praktika_neoflex.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper mapper;

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

}
