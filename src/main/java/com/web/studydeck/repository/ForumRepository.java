package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {
    // Queries for forum operations
}

