package com.web.studydeck.service.impl;

import com.web.studydeck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.Collections;

@Service
public class UserDetailsService implements ReactiveUserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> {
                    return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                            .password(user.getPassword())
                            .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build();
                });
    }
}
