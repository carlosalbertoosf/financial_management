package com.carlosalbertoosf.personal_finance_api.repository;

import com.carlosalbertoosf.personal_finance_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
