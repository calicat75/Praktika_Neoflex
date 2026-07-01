package com.example.praktika_neoflex.mapper;

import com.example.praktika_neoflex.dto.response.AccountResponse;
import com.example.praktika_neoflex.dto.response.AccountTypeResponse;
import com.example.praktika_neoflex.dto.response.CurrencyResponse;
import com.example.praktika_neoflex.dto.response.StatusHistoryResponse;
import com.example.praktika_neoflex.entity.Account;
import com.example.praktika_neoflex.entity.AccountStatusHistory;
import com.example.praktika_neoflex.entity.AccountTypeEntity;
import com.example.praktika_neoflex.entity.Currency;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {

    public AccountResponse toResponse(Account account) {

        return new AccountResponse(

                account.getId(),

                account.getAccountNumber(),

                account.getOwnerId(),

                account.getOwnerType(),

                toCurrency(account.getCurrency()),

                toAccountType(account.getAccountType()),

                account.getBalance(),

                account.getAccountStatus(),

                account.getCreatedAt(),

                account.getUpdatedAt(),

                account.getCreatedBy(),

                account.getUpdatedBy(),

                account.getVersion(),

                account.getHistory()

                        .stream()

                        .map(this::toStatusHistoryResponse)

                        .toList()

        );

    }

    private CurrencyResponse toCurrency(Currency currency) {

        return new CurrencyResponse(

                currency.getId(),

                currency.getCode(),

                currency.getName(),

                currency.getSymbol()

        );

    }

    private AccountTypeResponse toAccountType(AccountTypeEntity entity) {

        return new AccountTypeResponse(

                entity.getId(),

                entity.getName().name(),

                entity.getDescription()

        );

    }

    public StatusHistoryResponse toStatusHistoryResponse(AccountStatusHistory history) {

        return new StatusHistoryResponse(

                history.getId(),

                history.getOldStatus(),

                history.getNewStatus(),

                history.getReason(),

                history.getChangedBy(),

                history.getChangedAt()

        );

    }

    public List<AccountResponse> toResponseList(List<Account> accounts) {

        return accounts

                .stream()

                .map(this::toResponse)

                .toList();

    }

}
