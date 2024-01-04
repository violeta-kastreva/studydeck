package com.web.studydeck.web;

import com.web.studydeck.model.entity.Deck;
import com.web.studydeck.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Deck>> listDecksByUser(@PathVariable Long userId) {
        List<Deck> decks = deckService.findDecksByUserId(userId);
        return ResponseEntity.ok(decks);
    }

    @PostMapping("/create")
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck newDeck = deckService.saveDeck(deck);
        return ResponseEntity.ok(newDeck);
    }

    @PutMapping("/{deckId}/edit")
    public ResponseEntity<Deck> editDeck(@PathVariable Long deckId, @RequestBody Deck deck) {
        Deck updatedDeck = deckService.saveDeck(deck); // Assuming saveDeck handles updates
        return ResponseEntity.ok(updatedDeck);
    }

    @DeleteMapping("/{deckId}")
    public ResponseEntity<?> deleteDeck(@PathVariable Long deckId) {
        deckService.deleteDeck(deckId);
        return ResponseEntity.ok().build();
    }

    // Other deck-related methods...
}
