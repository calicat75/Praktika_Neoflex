package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.dto.response.StatusHistoryResponse;

import java.util.List;
import java.util.UUID;

public interface StatusHistoryService {

    List<StatusHistoryResponse> getHistory(UUID accountId);

}
