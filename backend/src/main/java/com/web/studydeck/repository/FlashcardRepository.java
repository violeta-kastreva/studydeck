package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    @Query("SELECT f FROM Flashcard f WHERE f.deck.user.id = :userId")
    List<Flashcard> findSharedByUserId(Long userId);

}
