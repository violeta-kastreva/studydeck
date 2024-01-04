package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.UserRegistrationDTO;
import com.web.studydeck.model.service.UserResponseDTO;
import com.web.studydeck.model.service.UserUpdateDTO;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Mono<UserResponseDTO> registerUser(UserRegistrationDTO registrationDTO) {
        User user = modelMapper.map(registrationDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user)
                .map(u -> modelMapper.map(u, UserResponseDTO.class));
    }

    @Override
    public Mono<UserResponseDTO> updateUser(Long id, UserUpdateDTO updateDTO) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    modelMapper.map(updateDTO, user);
                    return userRepository.save(user);
                })
                .map(user -> modelMapper.map(user, UserResponseDTO.class));
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Flux<UserResponseDTO> findAllUsers() {
        return userRepository.findAll()
                .map(user -> modelMapper.map(user, UserResponseDTO.class));
    }

    @Override
    public Mono<UserResponseDTO> findUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserResponseDTO.class));
    }
}
