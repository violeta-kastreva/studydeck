package com.web.studydeck.service;

import com.web.studydeck.model.service.UserRegistrationDTO;
import com.web.studydeck.model.service.UserResponseDTO;
import com.web.studydeck.model.service.UserUpdateDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(UserRegistrationDTO registrationDTO);
    UserResponseDTO updateUser(Long id, UserUpdateDTO updateDTO);
    void deleteUser(Long id);
    List<UserResponseDTO> findAllUsers();
    UserResponseDTO findUserById(Long id);

     UserResponseDTO authenticateUser(String username, String password);

    }
