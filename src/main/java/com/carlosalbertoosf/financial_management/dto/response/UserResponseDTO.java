package com.carlosalbertoosf.financial_management.dto.response;

import com.carlosalbertoosf.financial_management.model.Transaction;

import java.util.List;
import java.util.Objects;

public record UserResponseDTO(
        Long id,

        String name,

        String email
) {}