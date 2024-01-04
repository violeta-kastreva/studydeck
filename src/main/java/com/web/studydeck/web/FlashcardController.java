package com.web.studydeck.web;

import com.web.studydeck.model.entity.Flashcard;
import com.web.studydeck.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @PostMapping
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
        Flashcard newFlashcard = flashcardService.saveFlashcard(flashcard);
        return ResponseEntity.ok(newFlashcard);
    }

    @GetMapping("/{flashcardId}")
    public ResponseEntity<Flashcard> getFlashcard(@PathVariable Long flashcardId) {
        Flashcard flashcard = flashcardService.findFlashcardById(flashcardId);
        return ResponseEntity.ok(flashcard);
    }

    @PutMapping("/{flashcardId}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable Long flashcardId, @RequestBody Flashcard flashcard) {
        Flashcard updatedFlashcard = flashcardService.saveFlashcard(flashcard);
        return ResponseEntity.ok(updatedFlashcard);
    }

    @DeleteMapping("/{flashcardId}")
    public ResponseEntity<?> deleteFlashcard(@PathVariable Long flashcardId) {
        flashcardService.deleteFlashcard(flashcardId);
        return ResponseEntity.ok().build();
    }

    // Other flashcard-related methods...
}
