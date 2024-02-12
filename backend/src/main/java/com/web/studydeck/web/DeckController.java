package com.web.studydeck.web;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.DeckDTO;
import com.web.studydeck.model.service.ResponseStacksDTO;
import com.web.studydeck.model.service.ShowDeckDTO;
import com.web.studydeck.model.service.ShowFlashcardDTO;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeckDTO>> listDecksByUser(@PathVariable Long userId) {
        List<DeckDTO> decks = deckService.findDecksByUserId(userId);
        return ResponseEntity.ok(decks);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseStacksDTO> createDeck(@RequestBody ResponseStacksDTO responseStacksDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Long userId = user.getId();
        ShowDeckDTO temp = responseStacksDTO.getDecks().get(0);
        DeckDTO deckDTO = new DeckDTO();
        deckDTO.setUserId(userId);
        deckDTO.setData(new HashSet<>());
        for(ShowFlashcardDTO showFlashcardDTO : temp.getData()){
            deckDTO.getData().add(showFlashcardDTO);
        }
        deckDTO.setDescription(temp.getDescription());
        deckDTO.setFilters(temp.getFilters());
        deckDTO.setName(temp.getName());
        DeckDTO savedDeck = deckService.saveDeck(deckDTO);
        ResponseStacksDTO responseStacksDTOO = new ResponseStacksDTO();
        responseStacksDTOO.setTitle("New Stack");
        responseStacksDTOO.setDecks(new ArrayList<>());
        responseStacksDTOO.getDecks().add(new ShowDeckDTO(deckDTO.getName(), deckDTO.getDescription(), deckDTO.getFilters(), deckDTO.getData()));
        return ResponseEntity.ok(responseStacksDTOO);

    }

    @PutMapping("/{deckId}/edit")
    public ResponseEntity<DeckDTO> editDeck(@PathVariable Long deckId, @RequestBody DeckDTO deckDTO) {
        deckDTO.setId(deckId);
        DeckDTO updatedDeck = deckService.saveDeck(deckDTO);
        return ResponseEntity.ok(updatedDeck);
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<Void> deleteDeck(@PathVariable Long deckId) {
        deckService.deleteDeck(deckId);
        return ResponseEntity.ok().build();
    }
}
