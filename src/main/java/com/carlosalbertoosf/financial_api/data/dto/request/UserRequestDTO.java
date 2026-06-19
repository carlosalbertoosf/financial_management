package com.carlosalbertoosf.financial_api.data.dto.request;

import jakarta.validation.constraints.*;

import java.util.Objects;

public class UserRequestDTO{
        @NotBlank
        @Size(min = 3, max = 50)
        String name;

        @NotBlank
        @Email
        String email;

        @NotBlank
        @Size(min = 6, max = 50)
        String password;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Override
        public boolean equals(Object o) {
                if (o == null || getClass() != o.getClass()) return false;
                UserRequestDTO that = (UserRequestDTO) o;
                return Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getName(), getEmail(), getPassword());
        }
}


