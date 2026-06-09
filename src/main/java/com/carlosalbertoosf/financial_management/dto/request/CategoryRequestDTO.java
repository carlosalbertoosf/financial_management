package com.carlosalbertoosf.financial_management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
        @NotBlank
        @Size(min = 5, max = 50)
        String name
) {}
