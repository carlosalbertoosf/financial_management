package com.carlosalbertoosf.financial_management.config;

import com.carlosalbertoosf.financial_management.model.Category;
import com.carlosalbertoosf.financial_management.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public DataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        Category category = new Category();
        category.setName("Alimentação");

        categoryRepository.save(category);

        System.out.println("Categoria salva com sucesso!");
    }
}