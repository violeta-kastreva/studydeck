package com.web.studydeck.web;

import com.web.studydeck.model.service.FlashcardDTO;
import com.web.studydeck.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards/shared")
public class SharedFlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<FlashcardDTO>> listSharedFlashcards(@PathVariable Long userId) {
        List<FlashcardDTO> sharedFlashcards = flashcardService.findSharedFlashcardsByUserId(userId);
        return ResponseEntity.ok(sharedFlashcards);
    }
}
