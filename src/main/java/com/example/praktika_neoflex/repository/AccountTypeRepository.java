package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.AccountTypeEntity;
import com.example.praktika_neoflex.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypeEntity, UUID> {

    Optional<AccountTypeEntity> findByName(AccountType name);

}
