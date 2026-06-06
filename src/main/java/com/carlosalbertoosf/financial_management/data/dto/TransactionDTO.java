package com.carlosalbertoosf.financial_management.data.dto;

import com.carlosalbertoosf.financial_management.model.Category;
import com.carlosalbertoosf.financial_management.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class TransactionDTO {

    private Long id;

    private String description;

    private BigDecimal amount;

    private LocalDate date;

    private Category category;

    private User user;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDTO that = (TransactionDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(category, that.category) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getAmount(), getDate(), category, user);
    }
}
