package com.carlosalbertoosf.financial_management.controllers;

import com.carlosalbertoosf.financial_management.data.dto.request.TransactionRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.financial_management.service.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financial/transaction")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @GetMapping
    public List<TransactionResponseDTO> findAll() {
        return transactionServices.findAll();
    }

    @GetMapping(value = "/{id}")
    public TransactionResponseDTO findById(@PathVariable("id") Long id) {
        return transactionServices.findById(id);
    }

    @PostMapping()
    public TransactionResponseDTO create(@RequestBody TransactionRequestDTO transaction) {
        return transactionServices.create(transaction);
    }

    @PutMapping(value = "/{id}")
    public TransactionResponseDTO update(@PathVariable("id") Long id, @RequestBody TransactionRequestDTO transaction) {
        return transactionServices.update(id, transaction);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        transactionServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
