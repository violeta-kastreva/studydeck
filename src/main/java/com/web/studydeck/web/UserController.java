package com.web.studydeck.web;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.UserRegistrationDTO;
import com.web.studydeck.model.service.UserResponseDTO;
import com.web.studydeck.model.service.UserUpdateDTO;
import com.web.studydeck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Mono<UserResponseDTO> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        return userService.registerUser(registrationDTO);
    }

    @PutMapping("/{userId}")
    public Mono<ResponseEntity<UserResponseDTO>> updateUser(@PathVariable Long userId, @RequestBody UserUpdateDTO updateDTO) {
        return userService.updateUser(userId, updateDTO)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{userId}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId)
                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<UserResponseDTO> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public Mono<ResponseEntity<UserResponseDTO>> getUserById(@PathVariable Long userId) {
        return userService.findUserById(userId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
