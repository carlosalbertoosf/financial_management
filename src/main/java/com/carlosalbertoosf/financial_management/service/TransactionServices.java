package com.carlosalbertoosf.financial_management.service;

import com.carlosalbertoosf.financial_management.data.dto.request.TransactionRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.financial_management.model.Transaction;
import com.carlosalbertoosf.financial_management.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseObject;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseListObjects;

import java.util.List;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> findAll() {
        return parseListObjects(transactionRepository.findAll(), TransactionResponseDTO.class);
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));
        return parseObject(transaction, TransactionResponseDTO.class);
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto){
        Transaction entity = parseObject(dto, Transaction.class);
        return parseObject(transactionRepository.save(entity), TransactionResponseDTO.class);
    }

    public TransactionResponseDTO update(Long id, TransactionRequestDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());

        return parseObject(transactionRepository.save(transaction), TransactionResponseDTO.class);
    }

    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));

        transactionRepository.delete(transaction);
    }
}
