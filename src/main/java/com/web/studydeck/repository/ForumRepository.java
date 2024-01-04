package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ForumRepository extends ReactiveCrudRepository<Forum, Long> {
    // Reactive query methods...
}


