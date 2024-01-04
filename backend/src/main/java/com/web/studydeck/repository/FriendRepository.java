package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.enums.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByUserId(Long userId);
    // Custom queries for handling friendships

    List<Friend> findByFriendIdAndStatus(Long friendId, FriendStatus status);

}
