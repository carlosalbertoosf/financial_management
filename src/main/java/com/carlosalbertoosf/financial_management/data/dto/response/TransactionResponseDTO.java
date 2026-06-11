package com.carlosalbertoosf.financial_management.data.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionResponseDTO {
    Long id;

    String description;

    BigDecimal amount;

    LocalDate date;

    String categoryName;

    String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResponseDTO that = (TransactionResponseDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getCategoryName(), that.getCategoryName()) && Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getAmount(), getDate(), getCategoryName(), getUserName());
    }
}
