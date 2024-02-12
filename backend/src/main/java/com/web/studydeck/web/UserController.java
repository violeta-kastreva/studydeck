package com.web.studydeck.web;

import com.web.studydeck.model.service.AuthenticationResponse;
import com.web.studydeck.model.service.UserLoginDTO;
import com.web.studydeck.model.service.UserRegistrationDTO;
import com.web.studydeck.model.service.UserResponseDTO;
import com.web.studydeck.security.JwtUtil;
import com.web.studydeck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginDTO) {
        UserResponseDTO user = userService.authenticateUser
                (loginDTO.getUsername(), loginDTO.getPassword());
        final String jwt = jwtUtil.generateToken(loginDTO.getUsername());

        if (user != null) {
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        UserResponseDTO registeredUser = userService.registerUser(registrationDTO);
        return ResponseEntity.ok(registeredUser);
    }

//    @PutMapping("/{userId}")
//    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long userId, @RequestBody UserUpdateDTO updateDTO) {
//        Optional<UserResponseDTO> updatedUser = Optional.ofNullable(userService.updateUser(userId, updateDTO));
//        if (updatedUser.isPresent()) {
//            return ResponseEntity.ok(updatedUser.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping
//    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
//        List<UserResponseDTO> users = userService.findAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long userId) {
//        Optional<UserResponseDTO> userDTO = Optional.ofNullable(userService.findUserById(userId));
//        if (userDTO.isPresent()) {
//            return ResponseEntity.ok(userDTO.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}

