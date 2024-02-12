package com.web.studydeck.model.service;

import java.util.Set;

public class DeckDTO {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String description;
    private Long userId; // Assuming each deck is associated with a user

    private Set<ShowFlashcardDTO> data;

    private Set<String> filters;

    public Set<String> getFilters() {
        return filters;
    }

    public void setFilters(Set<String> filters) {
        this.filters = filters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ShowFlashcardDTO> getData() {
        return data;
    }

    public void setData(Set<ShowFlashcardDTO> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DeckDTO(Long id) {
        this.id = id;
    }

    public DeckDTO() {
    }
}
