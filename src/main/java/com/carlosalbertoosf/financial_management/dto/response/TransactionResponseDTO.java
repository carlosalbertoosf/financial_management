package com.carlosalbertoosf.financial_management.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionResponseDTO(
        Long id,

        String description,

        BigDecimal amount,

        LocalDate date,

        String categoryName,

        String userName
) {}
