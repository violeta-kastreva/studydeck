package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Deck;
import com.web.studydeck.model.entity.Flashcard;
import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.DeckDTO;
import com.web.studydeck.model.service.ShowDeckDTO;
import com.web.studydeck.model.service.ShowFlashcardDTO;
import com.web.studydeck.repository.DeckRepository;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.DeckService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckServiceImpl implements DeckService {


    private DeckRepository deckRepository;


    private UserRepository userRepository;

    @Autowired
    public DeckServiceImpl(DeckRepository deckRepository, UserRepository userRepository) {
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();;


    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public List<DeckDTO> findAllDecks() {
        return deckRepository.findAll().stream()
                .map(deck -> modelMapper.map(deck, DeckDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeckDTO findDeckById(Long id) {
        Deck deck = deckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Deck not found with id " + id));
        return modelMapper.map(deck, DeckDTO.class);
    }

    @Override
    public DeckDTO saveDeck(DeckDTO deckDTO) {
        Deck deck = modelMapper.map(deckDTO, Deck.class);
        deck.setDescription(deckDTO.getDescription());
        deck.setFilters(new HashSet<>());
        deck.setFilters(deckDTO.getFilters());
        deck.setName(deckDTO.getName());
        User user = userRepository.findById(deckDTO.getUserId()).orElse(null);

        deck.setUser(user);
        Deck savedDeck = deckRepository.save(deck);
        deckDTO.setData(new HashSet<>());
        for(ShowFlashcardDTO flashcardDTO : deckDTO.getData()){
            savedDeck.getFlashcards().add(new Flashcard(flashcardDTO.getQuestion(), flashcardDTO.getAnswer(), savedDeck));
        }
        deckRepository.saveAndFlush(savedDeck);
        return modelMapper.map(savedDeck, DeckDTO.class);
    }

    @Override
    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

    @Override
    public List<DeckDTO> findDecksByUserId(Long userId) {
        return deckRepository.findAllByUserId(userId).stream()
                .map(deck -> modelMapper.map(deck, DeckDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<ShowDeckDTO> findDecksToShowByUserId(Long userId) {
        return deckRepository.findAllByUserId(userId).stream()
                .map(deck -> {
                    ShowDeckDTO showDeckDTO = new ShowDeckDTO();
                    showDeckDTO.setDescription(deck.getDescription());
                    showDeckDTO.setName(deck.getName());
                    showDeckDTO.setFilters(deck.getFilters());
                    for(Flashcard flashcard : deck.getFlashcards()){
                        ShowFlashcardDTO showFlashcardDTO = new ShowFlashcardDTO();
                        showFlashcardDTO.setAnswer(flashcard.getAnswer());
                        showFlashcardDTO.setQuestion(flashcard.getQuestion());
                        showDeckDTO.getData().add(showFlashcardDTO);
                    }
                    return showDeckDTO;
                })
                .collect(Collectors.toList());
    }

}
