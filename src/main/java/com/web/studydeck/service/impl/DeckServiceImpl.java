package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Deck;
import com.web.studydeck.repository.DeckRepository;
import com.web.studydeck.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public List<Deck> findAllDecks() {
        return deckRepository.findAll();
    }

    @Override
    public Deck findDeckById(Long id) {
        return deckRepository.findById(id).orElse(null);
    }

    @Override
    public Deck saveDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

    @Override
    public List<Deck> findDecksByUserId(Long userId) {
        return deckRepository.findAllByUserId(userId);
    }

    // Additional business logic and methods
}
