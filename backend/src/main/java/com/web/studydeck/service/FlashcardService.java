package com.web.studydeck.service;

import com.web.studydeck.model.service.FlashcardDTO;

import java.util.List;

public interface FlashcardService {
    List<FlashcardDTO> findAllFlashcards();
    FlashcardDTO findFlashcardById(Long id);
    FlashcardDTO saveFlashcard(FlashcardDTO flashcardDTO);
    void deleteFlashcard(Long id);
    List<FlashcardDTO> findSharedFlashcardsByUserId(Long userId);
}
