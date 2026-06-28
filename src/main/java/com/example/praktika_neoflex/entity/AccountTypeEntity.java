package com.example.praktika_neoflex.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.bank.accountservice.enums.AccountType;

import java.util.UUID;

@Entity
@Table(name = "account_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private AccountType name;

    @Column(columnDefinition = "TEXT")
    private String description;

}
