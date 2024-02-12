package com.web.studydeck.model.service;

import java.util.List;

public class ResponseStacksDTO {
    String title;
    List<ShowDeckDTO> decks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ShowDeckDTO> getDecks() {
        return decks;
    }

    public void setDecks(List<ShowDeckDTO> decks) {
        this.decks = decks;
    }
}
