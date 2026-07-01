package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.AccountStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface AccountStatusHistoryRepository extends JpaRepository<AccountStatusHistory, UUID> {

    List<AccountStatusHistory> findByAccountId(UUID accountId);

}