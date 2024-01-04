package com.web.studydeck.service;

import com.web.studydeck.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    // Other necessary methods
}
