package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.enums.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface FriendRepository extends ReactiveCrudRepository<Friend, Long> {
    Flux<Friend> findAllByUserId(Long userId);
    Flux<Friend> findByFriendIdAndStatus(Long friendId, FriendStatus status);
}
