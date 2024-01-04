package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findAllByUserId(Long userId);
    // Queries specific to deck operations
}
