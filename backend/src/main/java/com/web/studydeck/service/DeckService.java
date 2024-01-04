package com.web.studydeck.service;

import com.web.studydeck.model.entity.Deck;

import java.util.List;

public interface DeckService {
    List<Deck> findAllDecks();
    Deck findDeckById(Long id);
    Deck saveDeck(Deck deck);
    void deleteDeck(Long id);

    List<Deck> findDecksByUserId(Long userId);
    // Other necessary methods
}
