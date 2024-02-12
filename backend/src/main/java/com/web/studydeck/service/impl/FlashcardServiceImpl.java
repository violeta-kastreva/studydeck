package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Flashcard;
import com.web.studydeck.model.service.FlashcardDTO;
import com.web.studydeck.repository.FlashcardRepository;
import com.web.studydeck.service.FlashcardService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlashcardServiceImpl implements FlashcardService {


    private FlashcardRepository flashcardRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FlashcardDTO> findAllFlashcards() {
        return flashcardRepository.findAll().stream()
                .map(flashcard -> modelMapper.map(flashcard, FlashcardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FlashcardDTO findFlashcardById(Long id) {
        Flashcard flashcard = flashcardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flashcard not found with id " + id));
        return modelMapper.map(flashcard, FlashcardDTO.class);
    }

    @Override
    public FlashcardDTO saveFlashcard(FlashcardDTO flashcardDTO) {
        Flashcard flashcard = modelMapper.map(flashcardDTO, Flashcard.class);
        Flashcard savedFlashcard = flashcardRepository.save(flashcard);
        return modelMapper.map(savedFlashcard, FlashcardDTO.class);
    }

    @Override
    public void deleteFlashcard(Long id) {
        flashcardRepository.deleteById(id);
    }

    @Override
    public List<FlashcardDTO> findSharedFlashcardsByUserId(Long userId) {
        // Implement based on your business logic and repository capabilities
        return null; // Placeholder for actual implementation
    }
}
