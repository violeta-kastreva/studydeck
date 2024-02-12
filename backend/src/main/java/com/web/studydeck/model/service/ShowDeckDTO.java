package com.web.studydeck.model.service;

import java.util.HashSet;
import java.util.Set;

public class ShowDeckDTO {
    private String name;

    private String description;

    private Set<String> filters;

    private Set<ShowFlashcardDTO> data = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getFilters() {
        return filters;
    }

    public void setFilters(Set<String> filters) {
        this.filters = filters;
    }

    public Set<ShowFlashcardDTO> getData() {
        return data;
    }

    public void setData(Set<ShowFlashcardDTO> data) {
        this.data = data;
    }

    public ShowDeckDTO(String name, String description, Set<String> filters, Set<ShowFlashcardDTO> data) {
        this.name = name;
        this.description = description;
        this.filters = filters;
        this.data = data;
    }

    public ShowDeckDTO() {
    }
}
