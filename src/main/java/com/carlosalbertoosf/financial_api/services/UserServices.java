package com.carlosalbertoosf.financial_api.services;

import com.carlosalbertoosf.financial_api.data.dto.request.UserRequestDTO;
import com.carlosalbertoosf.financial_api.data.dto.response.UserResponseDTO;
import com.carlosalbertoosf.financial_api.model.User;
import com.carlosalbertoosf.financial_api.repository.UserRepository;
import static com.carlosalbertoosf.financial_api.mapper.ObjectMapper.parseObject;
import static com.carlosalbertoosf.financial_api.mapper.ObjectMapper.parseListObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        return parseListObjects(userRepository.findAll(), UserResponseDTO.class);
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return parseObject(user, UserResponseDTO.class);
    }

    public UserResponseDTO create(UserRequestDTO userDTO) {
        User user = parseObject(userDTO, User.class);

        User userSaved = userRepository.save(user);

        return parseObject(userSaved, UserResponseDTO.class);
    }

    public UserResponseDTO update(Long id, UserRequestDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return parseObject(userRepository.save(user), UserResponseDTO.class);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}
