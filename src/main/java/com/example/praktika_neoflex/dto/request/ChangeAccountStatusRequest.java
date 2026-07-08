package com.example.praktika_neoflex.dto.request;

import com.example.praktika_neoflex.enums.AccountStatus;
import lombok.Data;

@Data
public class ChangeAccountStatusRequest {

    private AccountStatus status;

    private String reason;

}