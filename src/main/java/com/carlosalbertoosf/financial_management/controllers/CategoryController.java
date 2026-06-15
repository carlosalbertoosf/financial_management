package com.carlosalbertoosf.financial_management.controllers;

import com.carlosalbertoosf.financial_management.data.dto.request.CategoryRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.CategoryResponseDTO;
import com.carlosalbertoosf.financial_management.service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public List<CategoryResponseDTO> findAll() {
        return categoryServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public CategoryResponseDTO findById(@PathVariable("id") Long id) {
        return categoryServices.findById(id);
    }

    @PostMapping
    public CategoryResponseDTO create(@RequestBody CategoryRequestDTO categoryName) {
        return categoryServices.create(categoryName);
    }

    @PutMapping(value = "/{id}")
    public CategoryResponseDTO update(@PathVariable("id") Long id, @RequestBody CategoryRequestDTO categoryName) {
        return categoryServices.update(id, categoryName);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
