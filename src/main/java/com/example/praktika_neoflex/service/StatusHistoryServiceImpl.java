package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.dto.response.StatusHistoryResponse;
import com.example.praktika_neoflex.mapper.AccountMapper;
import com.example.praktika_neoflex.repository.AccountStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatusHistoryServiceImpl implements StatusHistoryService {

    private final AccountStatusHistoryRepository repository;

    private final AccountMapper mapper;

    @Override
    public List<StatusHistoryResponse> getHistory(UUID accountId) {

        return repository.findByAccountId(accountId)
                .stream()
                .map(mapper::toStatusHistoryResponse)
                .toList();

    }

}
