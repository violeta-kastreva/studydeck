package com.web.studydeck.repository;

import com.web.studydeck.model.entity.ForumPost;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ForumPostRepository extends ReactiveCrudRepository<ForumPost, Long> {
    // Reactive query methods...
}
