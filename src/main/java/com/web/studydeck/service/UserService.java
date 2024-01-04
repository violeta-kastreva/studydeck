package com.web.studydeck.service;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.UserRegistrationDTO;
import com.web.studydeck.model.service.UserResponseDTO;
import com.web.studydeck.model.service.UserUpdateDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Mono<UserResponseDTO> registerUser(UserRegistrationDTO registrationDTO);
    Mono<UserResponseDTO> updateUser(Long id, UserUpdateDTO updateDTO);
    Mono<Void> deleteUser(Long id);
    Flux<UserResponseDTO> findAllUsers();
    Mono<UserResponseDTO> findUserById(Long id);
}
