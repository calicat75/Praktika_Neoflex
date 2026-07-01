package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.AccountTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountTypeRepository extends JpaRepository<AccountTypeEntity, UUID> {

    Optional<AccountTypeEntity> findByName(String name);

}
