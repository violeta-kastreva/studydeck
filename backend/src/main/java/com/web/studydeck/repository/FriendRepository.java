package com.web.studydeck.repository;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.enums.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByUserId(Long userId);
    List<Friend> findByFriendIdAndStatus(Long friendId, FriendStatus status);
    List<Friend> findFirstByFriendIdAndStatus(Long friendId, FriendStatus status);

    Optional<Friend> findFirstByUserAndFriend(User requester, User acceptor);
}
