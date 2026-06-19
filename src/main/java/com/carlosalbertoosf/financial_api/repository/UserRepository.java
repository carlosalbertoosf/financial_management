package com.carlosalbertoosf.financial_api.repository;

import com.carlosalbertoosf.financial_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
