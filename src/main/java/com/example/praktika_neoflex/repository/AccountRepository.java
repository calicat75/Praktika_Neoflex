package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface AccountRepository extends JpaRepository<Account, UUID> {

    List<Account> findByOwnerId(UUID ownerId);

    Optional<Account> findByAccountNumber(String accountNumber);

}
