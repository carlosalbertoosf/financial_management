package com.carlosalbertoosf.financial_management.mapper;

import com.carlosalbertoosf.financial_management.dto.request.CategoryRequestDTO;
import com.carlosalbertoosf.financial_management.dto.response.CategoryResponseDTO;
import com.carlosalbertoosf.financial_management.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO dto) {

        Category entity = new Category();

        entity.setName(dto.name());

        return entity;
    }

    public CategoryResponseDTO toDTO(Category entity) {

        return new CategoryResponseDTO(
                entity.getId(),
                entity.getName()
        );
    }
}
