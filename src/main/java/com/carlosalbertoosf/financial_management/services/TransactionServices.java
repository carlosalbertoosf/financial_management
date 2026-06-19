package com.carlosalbertoosf.financial_management.services;

import com.carlosalbertoosf.financial_management.data.dto.request.TransactionRequestDTO;
import com.carlosalbertoosf.financial_management.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.financial_management.model.Category;
import com.carlosalbertoosf.financial_management.model.Transaction;
import com.carlosalbertoosf.financial_management.model.User;
import com.carlosalbertoosf.financial_management.repository.CategoryRepository;
import com.carlosalbertoosf.financial_management.repository.TransactionRepository;
import com.carlosalbertoosf.financial_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseObject;
import static com.carlosalbertoosf.financial_management.mapper.ObjectMapper.parseListObjects;

import java.util.List;

@Service
public class TransactionServices {

    @Autowired
    private Transaction transaction;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<TransactionResponseDTO> findAll() {
        return parseListObjects(transactionRepository.findAll(), TransactionResponseDTO.class);
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));
        return parseObject(transaction, TransactionResponseDTO.class);
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User with id " + dto.getUserId() + " not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category with id " + dto.getCategoryId() + " not found"));

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setCategory(category);
        transaction.setUser(user);

        Transaction entitySaved = transactionRepository.save(transaction);

        return parseObject(entitySaved, TransactionResponseDTO.class);
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
