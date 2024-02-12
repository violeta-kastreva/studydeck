package com.web.studydeck.model.service;

public class FlashcardDTO {
    private Long id;
    private String question;
    private String answer;
    private Long deckId; // Assuming each flashcard is part of a deck

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }

    // Constructors, Getters, and Setters
}

