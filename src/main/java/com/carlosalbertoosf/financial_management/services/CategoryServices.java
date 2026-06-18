package com.carlosalbertoosf.financial_management.services;

import com.carlosalbertoosf.financial_management.data.dto.request.CategoryRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.CategoryResponseDTO;
import com.carlosalbertoosf.financial_management.model.Category;
import com.carlosalbertoosf.financial_management.repository.CategoryRepository;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseObject;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseListObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryResponseDTO> findAll() {
        return parseListObjects(categoryRepository.findAll(), CategoryResponseDTO.class);
    }

    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        return parseObject(category, CategoryResponseDTO.class);
    }

    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category category = parseObject(dto, Category.class);

        Category categorySaved = categoryRepository.save(category);

        return parseObject(categorySaved, CategoryResponseDTO.class);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
      Category category = categoryRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Category not found!"));

      category.setName(dto.getName());

      categoryRepository.save(category);

      return parseObject(category, CategoryResponseDTO.class);
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        categoryRepository.delete(category);
    }
}
