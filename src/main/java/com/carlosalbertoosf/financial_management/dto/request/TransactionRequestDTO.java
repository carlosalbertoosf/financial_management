package com.carlosalbertoosf.financial_management.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class TransactionRequestDTO {
        @NotBlank @Size(min = 5, max = 50)
        String description;

        @Positive
        BigDecimal amount;

        @NotNull
        Long categoryId;

        @NotNull
        Long userI;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public BigDecimal getAmount() {
                return amount;
        }

        public void setAmount(BigDecimal amount) {
                this.amount = amount;
        }

        public Long getCategoryId() {
                return categoryId;
        }

        public void setCategoryId(Long categoryId) {
                this.categoryId = categoryId;
        }

        public Long getUserI() {
                return userI;
        }

        public void setUserI(Long userI) {
                this.userI = userI;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                TransactionRequestDTO that = (TransactionRequestDTO) o;
                return Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getCategoryId(), that.getCategoryId()) && Objects.equals(getUserI(), that.getUserI());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getDescription(), getAmount(), getCategoryId(), getUserI());
        }
}
