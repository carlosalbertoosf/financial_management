package com.carlosalbertoosf.financial_api.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class CategoryRequestDTO {
        @NotBlank
        @Size(min = 5, max = 50)
        String name;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                CategoryRequestDTO that = (CategoryRequestDTO) o;
                return Objects.equals(getName(), that.getName());
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(getName());
        }
}
