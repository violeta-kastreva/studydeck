package com.web.studydeck.web;

import com.web.studydeck.model.service.FlashcardDTO;
import com.web.studydeck.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @PostMapping
    public ResponseEntity<FlashcardDTO> createFlashcard(@RequestBody FlashcardDTO flashcardDTO) {
        FlashcardDTO savedFlashcard = flashcardService.saveFlashcard(flashcardDTO);
        return ResponseEntity.ok(savedFlashcard);
    }

    @GetMapping("/{flashcardId}")
    public ResponseEntity<FlashcardDTO> getFlashcard(@PathVariable Long flashcardId) {
        Optional<FlashcardDTO> flashcardDTO = Optional.ofNullable(flashcardService.findFlashcardById(flashcardId));
        if (flashcardDTO.isPresent()) {
            return ResponseEntity.ok(flashcardDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{flashcardId}")
    public ResponseEntity<FlashcardDTO> updateFlashcard(@PathVariable Long flashcardId, @RequestBody FlashcardDTO flashcardDTO) {
        flashcardDTO.setId(flashcardId);
        FlashcardDTO updatedFlashcard = flashcardService.saveFlashcard(flashcardDTO);
        return ResponseEntity.ok(updatedFlashcard);
    }

    @DeleteMapping("/{flashcardId}")
    public ResponseEntity<Void> deleteFlashcard(@PathVariable Long flashcardId) {
        flashcardService.deleteFlashcard(flashcardId);
        return ResponseEntity.ok().build();
    }
}
