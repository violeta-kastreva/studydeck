package com.web.studydeck.repository;
import com.web.studydeck.model.entity.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    // Custom queries for flashcard operations

}
