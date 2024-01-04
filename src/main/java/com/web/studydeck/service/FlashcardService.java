package com.web.studydeck.service;

import com.web.studydeck.model.entity.Flashcard;

import java.util.List;

public interface FlashcardService {
    List<Flashcard> findAllFlashcards();
    Flashcard findFlashcardById(Long id);
    Flashcard saveFlashcard(Flashcard flashcard);
    void deleteFlashcard(Long id);
    // Other necessary methods
}
