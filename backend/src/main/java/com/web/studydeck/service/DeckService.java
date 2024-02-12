package com.web.studydeck.service;

import com.web.studydeck.model.service.DeckDTO;
import com.web.studydeck.model.service.ShowDeckDTO;

import java.util.List;


public interface DeckService {
    List<DeckDTO> findAllDecks();
    DeckDTO findDeckById(Long id);
    DeckDTO saveDeck(DeckDTO deckDTO);
    void deleteDeck(Long id);
    List<DeckDTO> findDecksByUserId(Long userId);

    List<ShowDeckDTO> findDecksToShowByUserId(Long userId);

}

