package com.carlosalbertoosf.financial_management.controllers;

import com.carlosalbertoosf.financial_management.data.dto.request.UserRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.UserResponseDTO;
import com.carlosalbertoosf.financial_management.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping(
            produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_YAML_VALUE }
    )
    public List<UserResponseDTO> findAll() {
        return userServices.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
                MediaType.APPLICATION_YAML_VALUE }
    )
    public UserResponseDTO findById(@PathVariable("id") Long id) {
        return userServices.findById(id);
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
    public UserResponseDTO create(@RequestBody UserRequestDTO user) {
        return userServices.create(user);
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
    public UserResponseDTO update(@PathVariable("id") Long id, @RequestBody UserRequestDTO user) {
        return userServices.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
