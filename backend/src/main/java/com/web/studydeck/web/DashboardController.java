package com.web.studydeck.web;


import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.ResponseStacksDTO;
import com.web.studydeck.model.service.ShowDeckDTO;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DashboardController {
    @Autowired
    private DeckService deckService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public ResponseEntity<List<ResponseStacksDTO>> listSharedFlashcards(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(new User());
        Long userId = user.getId();
        List<ShowDeckDTO> sharedDecks = deckService.findDecksToShowByUserId(userId);
        ResponseStacksDTO responseStacksDTO = new ResponseStacksDTO();
        responseStacksDTO.setDecks(sharedDecks);
        responseStacksDTO.setTitle("Latest Cards");

        ResponseStacksDTO responseStacksDTO1 = new ResponseStacksDTO();
        responseStacksDTO1.setDecks(sharedDecks);

        responseStacksDTO1.setTitle("Favorites");
        List<ResponseStacksDTO> stacks = new ArrayList<>();
        stacks.add(responseStacksDTO);
        stacks.add(responseStacksDTO1);

        return ResponseEntity.ok(stacks);
    }
}

