package com.carlosalbertoosf.financial_api.mapper.custom;

import com.carlosalbertoosf.financial_api.data.dto.response.TransactionResponseDTO;
import com.carlosalbertoosf.financial_api.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionMapper {

    public TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();

        dto.setId(transaction.getId());
        dto.setDescription(transaction.getDescription());
        dto.setAmount(transaction.getAmount());
        dto.setDate(transaction.getDate());
        dto.setCategoryName(transaction.getCategory().getName());
        dto.setUserName(transaction.getUser().getName());
        return dto;
    }

    public List<TransactionResponseDTO> listToDTOs(List<Transaction> transactions) {
        List<TransactionResponseDTO> listDTOs = new ArrayList<>();

        for (Transaction transaction : transactions) {
            TransactionResponseDTO dto = toDTO(transaction);
            listDTOs.add(dto);
        }
        return listDTOs;
    }
}
