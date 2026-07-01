package com.example.praktika_neoflex.entity;

import com.example.praktika_neoflex.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

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
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private AccountType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
