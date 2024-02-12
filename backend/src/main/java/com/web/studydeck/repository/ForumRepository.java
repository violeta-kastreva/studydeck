package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ForumRepository extends JpaRepository<Forum, Long> {
    Optional<Forum> findByTitle(String name);


    // Reactive query methods...
}


