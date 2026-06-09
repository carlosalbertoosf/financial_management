package com.carlosalbertoosf.financial_management.service;

import com.carlosalbertoosf.financial_management.mapper.CategoryMapper;
import com.carlosalbertoosf.financial_management.dto.request.CategoryRequestDTO;
import com.carlosalbertoosf.financial_management.dto.response.CategoryResponseDTO;
import com.carlosalbertoosf.financial_management.model.Category;
import com.carlosalbertoosf.financial_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        var entity = categoryMapper.toEntity(dto);

        var entitySaved = categoryRepository.save(entity);

        return categoryMapper.toDTO(entitySaved);
    }
}
