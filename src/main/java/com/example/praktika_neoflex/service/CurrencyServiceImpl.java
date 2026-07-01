package com.example.praktika_neoflex.service;

import com.example.praktika_neoflex.entity.Currency;
import com.example.praktika_neoflex.exception.CurrencyNotFoundException;
import com.example.praktika_neoflex.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency getCurrency(UUID id) {

        return currencyRepository.findById(id)
                .orElseThrow(() ->
                        new CurrencyNotFoundException(
                                "Currency not found: " + id
                        ));

    }

}
