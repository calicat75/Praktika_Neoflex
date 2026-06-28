package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.Account;
import com.example.praktika_neoflex.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import jakarta.persistence.LockModeType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByOwnerId(UUID ownerId);

    List<Account> findByOwnerIdAndAccountStatus(UUID ownerId,
                                                AccountStatus status);

    boolean existsByAccountNumber(String accountNumber);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            select a
            from Account a
            where a.id = :id
            """)
    Optional<Account> findByIdForUpdate(@Param("id") UUID id);

}
