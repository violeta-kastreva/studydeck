package com.web.studydeck.repository;

import com.web.studydeck.model.entity.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
    // Queries for forum post operations
}
