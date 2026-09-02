package com.carlosalbertoosf.personal_finance_api.services;

import com.carlosalbertoosf.personal_finance_api.controllers.TransactionController;
import com.carlosalbertoosf.personal_finance_api.data.dto.request.TransactionRequestDTO;
import com.carlosalbertoosf.personal_finance_api.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.personal_finance_api.exceptions.ResourceNotFoundException;
import com.carlosalbertoosf.personal_finance_api.mapper.custom.TransactionMapper;
import com.carlosalbertoosf.personal_finance_api.model.Category;
import com.carlosalbertoosf.personal_finance_api.model.Transaction;
import com.carlosalbertoosf.personal_finance_api.model.User;
import com.carlosalbertoosf.personal_finance_api.repository.CategoryRepository;
import com.carlosalbertoosf.personal_finance_api.repository.TransactionRepository;
import com.carlosalbertoosf.personal_finance_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

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
        var transactions = converter.listToDTOs(transactionRepository.findAll());
        transactions.forEach(this::addHateoasLinks);
        return transactions;
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " not found"));

        var responseDTO = converter.toDTO(transaction);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + dto.getUserId() + " not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + dto.getCategoryId() + " not found"));

        Transaction transaction = new Transaction();
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setCategory(category);
        transaction.setUser(user);

        transactionRepository.save(transaction);

        var responseDTO = converter.toDTO(transaction);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public TransactionResponseDTO update(Long id, TransactionRequestDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " not found"));

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());

        transactionRepository.save(transaction);

        var responseDTO = converter.toDTO(transaction);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction with id " + id + " not found"));

        transactionRepository.delete(transaction);
    }

    private void addHateoasLinks(TransactionResponseDTO dto) {
        dto.add(linkTo(methodOn(TransactionController.class)
                .findById(dto.getId()))
                .withSelfRel()
                .withType("GET"));

        dto.add(linkTo(methodOn(TransactionController.class)
                .findAll())
                .withRel("findAll")
                .withType("GET"));

        dto.add(linkTo(methodOn(TransactionController.class)
                .create(null))
                .withRel("create")
                .withType("POST"));

        dto.add(linkTo(methodOn(TransactionController.class)
                .update(dto.getId(), null))
                .withRel("update")
                .withType("PUT"));

        dto.add(linkTo(methodOn(TransactionController.class)
                .delete(dto.getId()))
                .withRel("delete")
                .withType("DELETE"));
    }
}
