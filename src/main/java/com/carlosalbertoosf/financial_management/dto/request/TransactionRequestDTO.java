package com.carlosalbertoosf.financial_management.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TransactionRequestDTO(

        @NotBlank @Size(min = 5, max = 50)
        String description,

        @Positive
        BigDecimal amount,

        @NotNull
        Long categoryId,

        @NotNull
        Long userId
) {}
