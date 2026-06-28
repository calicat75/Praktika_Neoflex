package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.AccountStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface AccountStatusHistoryRepository
        extends JpaRepository<AccountStatusHistory, UUID> {

    List<AccountStatusHistory> findByAccountIdOrderByChangedAtDesc(UUID accountId);

}