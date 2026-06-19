package com.carlosalbertoosf.financial_api.services;

import com.carlosalbertoosf.financial_api.data.dto.request.TransactionRequestDTO;
import com.carlosalbertoosf.financial_api.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.financial_api.mapper.custom.TransactionMapper;
import com.carlosalbertoosf.financial_api.model.Category;
import com.carlosalbertoosf.financial_api.model.Transaction;
import com.carlosalbertoosf.financial_api.model.User;
import com.carlosalbertoosf.financial_api.repository.CategoryRepository;
import com.carlosalbertoosf.financial_api.repository.TransactionRepository;
import com.carlosalbertoosf.financial_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.carlosalbertoosf.financial_api.mapper.ObjectMapper.parseListObjects;

import java.util.List;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TransactionMapper converter;

    public List<TransactionResponseDTO> findAll() {
        return parseListObjects(transactionRepository.findAll(), TransactionResponseDTO.class);
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));
        return converter.toDTO(transaction);
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User with id " + dto.getUserId() + " not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category with id " + dto.getCategoryId() + " not found"));

        Transaction transaction = new Transaction();
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setCategory(category);
        transaction.setUser(user);

        transactionRepository.save(transaction);

        return converter.toDTO(transaction);
    }

    public TransactionResponseDTO update(Long id, TransactionRequestDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());

        transactionRepository.save(transaction);

        return converter.toDTO(transaction);
    }

    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));

        transactionRepository.delete(transaction);
    }
}
