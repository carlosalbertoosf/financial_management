package com.carlosalbertoosf.personal_finance_api.services;

import com.carlosalbertoosf.personal_finance_api.controllers.UserController;
import com.carlosalbertoosf.personal_finance_api.data.dto.request.UserRequestDTO;
import com.carlosalbertoosf.personal_finance_api.data.dto.response.UserResponseDTO;
import com.carlosalbertoosf.personal_finance_api.model.User;
import com.carlosalbertoosf.personal_finance_api.repository.UserRepository;
import static com.carlosalbertoosf.personal_finance_api.mapper.ObjectMapper.parseObject;
import static com.carlosalbertoosf.personal_finance_api.mapper.ObjectMapper.parseListObjects;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        var users = parseListObjects(userRepository.findAll(), UserResponseDTO.class);
        users.forEach(this::addHateoasLinks);
        return users;
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        var responseDTO = parseObject(user, UserResponseDTO.class);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public UserResponseDTO create(UserRequestDTO userDTO) {
        User user = parseObject(userDTO, User.class);

        User userSaved = userRepository.save(user);

        var responseDTO = parseObject(userSaved, UserResponseDTO.class);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public UserResponseDTO update(Long id, UserRequestDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        var responseDTO = parseObject(userRepository.save(user), UserResponseDTO.class);
        addHateoasLinks(responseDTO);
        return responseDTO;
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    private void addHateoasLinks(UserResponseDTO dto) {
        dto.add(linkTo(methodOn(UserController.class)
                .findById(dto.getId()))
                .withSelfRel()
                .withType("GET"));

        dto.add(linkTo(methodOn(UserController.class)
                .findAll())
                .withRel("findAll")
                .withType("GET"));

        dto.add(linkTo(methodOn(UserController.class)
                .create(null))
                .withRel("create")
                .withType("POST"));

        dto.add(linkTo(methodOn(UserController.class)
                .update(dto.getId(), null))
                .withRel("update")
                .withType("PUT"));

        dto.add(linkTo(methodOn(UserController.class)
                .delete(dto.getId()))
                .withRel("delete")
                .withType("DELETE"));
    }
}
