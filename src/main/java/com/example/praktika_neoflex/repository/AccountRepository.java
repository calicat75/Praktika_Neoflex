package com.example.praktika_neoflex.repository;

import com.example.praktika_neoflex.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.history")
    List<Account> findAllWithHistory();

    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.history WHERE a.id = :id")
    Optional<Account> findByIdWithHistory(@Param("id") UUID id);

    @Query("SELECT a FROM Account a LEFT JOIN FETCH a.history WHERE a.ownerId = :ownerId")
    List<Account> findByOwnerIdWithHistory(@Param("ownerId") UUID ownerId);
}
