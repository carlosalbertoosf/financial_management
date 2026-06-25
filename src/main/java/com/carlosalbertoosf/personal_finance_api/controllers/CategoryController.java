package com.carlosalbertoosf.personal_finance_api.controllers;

import com.carlosalbertoosf.personal_finance_api.data.dto.request.CategoryRequestDTO;
import com.carlosalbertoosf.personal_finance_api.data.dto.response.CategoryResponseDTO;
import com.carlosalbertoosf.personal_finance_api.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("financial/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE }
    )
    public List<CategoryResponseDTO> findAll() {
        return categoryServices.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE }
    )
    public CategoryResponseDTO findById(@PathVariable("id") Long id) {
        return categoryServices.findById(id);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE }
    )
    public CategoryResponseDTO create(@RequestBody CategoryRequestDTO categoryName) {
        return categoryServices.create(categoryName);
    }

    @PutMapping(value = "/{id}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE }
    )
    public CategoryResponseDTO update(@PathVariable("id") Long id, @RequestBody CategoryRequestDTO categoryName) {
        return categoryServices.update(id, categoryName);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        categoryServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
