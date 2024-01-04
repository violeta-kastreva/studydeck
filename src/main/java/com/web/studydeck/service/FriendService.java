package com.web.studydeck.service;

import com.web.studydeck.model.entity.Friend;

import java.util.List;

public interface FriendService {
    List<Friend> findAllFriends();
    Friend findFriendById(Long id);
    Friend saveFriend(Friend friend);
    void deleteFriend(Long id);

    List<Friend> findFriendsByUserId(Long userId);

    List<Friend> findFriendRequestsByUserId(Long userId);

        // Other necessary methods
}
