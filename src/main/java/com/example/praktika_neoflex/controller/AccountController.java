package com.example.praktika_neoflex.controller;

import com.example.praktika_neoflex.dto.client.CustomerDto;
import com.example.praktika_neoflex.dto.request.ChangeAccountStatusRequest;
import com.example.praktika_neoflex.dto.response.AccountDetailsResponse;
import com.example.praktika_neoflex.dto.response.AccountResponse;
import com.example.praktika_neoflex.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Tag(name = "Accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    @Operation(summary = "Получить все счета")
    public List<AccountResponse> getAllAccounts() {

        return accountService.getAllAccounts();

    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить счет по UUID")
    public AccountResponse getById(
            @PathVariable UUID id
    ) {

        return accountService.getAccountById(id);

    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Получить счета клиента")
    public List<AccountResponse> getByCustomer(
            @PathVariable UUID customerId
    ) {

        return accountService.getAccountsByCustomer(customerId);

    }

    /*
    @GetMapping("/{id}/details")
    @Operation(summary = "Получить счет вместе с данными клиента, кредитами и транзакциями")
    public AccountDetailsResponse getDetails(
            @PathVariable UUID id
    ) {

        return accountService.getAccountDetails(id);

    }
    */

/*    @GetMapping("/customer/{customerId}/status")
    @Operation(summary = "Получить статус клиента")
    public CustomerDto getCustomerStatus(
            @PathVariable UUID customerId
    ) {

        return accountService.getCustomerStatus(customerId);

    }
*/

    @PatchMapping("/{id}/status")
    @Operation(summary = "Изменить статус счета")
    public AccountResponse changeStatus(
            @PathVariable UUID id,
            @RequestBody ChangeAccountStatusRequest request
    ) {

        return accountService.changeAccountStatus(id, request);

    }

}