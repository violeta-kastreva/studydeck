package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Flashcard;
import com.web.studydeck.repository.FlashcardRepository;
import com.web.studydeck.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashcardServiceImpl implements FlashcardService {

    @Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public List<Flashcard> findAllFlashcards() {
        return flashcardRepository.findAll();
    }

    @Override
    public Flashcard findFlashcardById(Long id) {
        return flashcardRepository.findById(id).orElse(null);
    }

    @Override
    public Flashcard saveFlashcard(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    @Override
    public void deleteFlashcard(Long id) {
        flashcardRepository.deleteById(id);
    }

    // Additional business logic and methods
}
