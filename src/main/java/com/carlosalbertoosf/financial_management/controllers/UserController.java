package com.carlosalbertoosf.financial_management.controllers;

import com.carlosalbertoosf.financial_management.data.dto.request.UserRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.UserResponseDTO;
import com.carlosalbertoosf.financial_management.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return userServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserResponseDTO findById(@PathVariable("id") Long id) {
        return userServices.findById(id);
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody UserRequestDTO user) {
        return userServices.create(user);
    }

    @PutMapping(value = "/{id}")
    public UserResponseDTO update(@PathVariable("id") Long id, @RequestBody UserRequestDTO user) {
        return userServices.update(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        userServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
