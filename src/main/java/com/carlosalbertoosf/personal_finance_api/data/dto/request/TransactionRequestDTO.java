package com.carlosalbertoosf.personal_finance_api.data.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionRequestDTO {
        @NotBlank @Size(min = 5, max = 50)
        String description;

        @Positive
        BigDecimal amount;

        @NotNull
        LocalDate date;

        @NotNull
        Long categoryId;

        @NotNull
        Long userId;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public BigDecimal getAmount() {
                return amount;
        }

        public void setAmount(BigDecimal amount) { this.amount = amount; }

        public LocalDate getDate() { return date; }

        public Long getCategoryId() { return categoryId; }

        public Long getUserId() { return userId; }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                TransactionRequestDTO that = (TransactionRequestDTO) o;
                return Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getCategoryId(), that.getCategoryId()) && Objects.equals(getUserId(), that.getUserId());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getDescription(), getAmount(), getCategoryId(), getUserId());
        }
}
