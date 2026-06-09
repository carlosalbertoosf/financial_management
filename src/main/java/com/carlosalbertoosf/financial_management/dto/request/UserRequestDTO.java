package com.carlosalbertoosf.financial_management.dto.request;

import jakarta.validation.constraints.*;

public record UserRequestDTO(

        @NotBlank
        @Size(min = 3, max = 50)
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 6, max = 50)
        String password
) {}


