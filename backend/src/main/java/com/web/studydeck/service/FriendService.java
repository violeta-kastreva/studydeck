package com.web.studydeck.service;

import com.web.studydeck.model.service.FriendDTO;
import com.web.studydeck.model.service.ShowFriendDTO;

import java.util.List;

public interface FriendService {
    List<FriendDTO> findAllFriends();
    FriendDTO findFriendById(Long userId);
    ShowFriendDTO saveFriend(ShowFriendDTO showFriendDTO, Long userId);
    ShowFriendDTO acceptFriend(ShowFriendDTO showFriendDTO, Long userId);
    void deleteFriend(String username, Long id);
    List<FriendDTO> findFriendsByUserId(Long userId);
    List<FriendDTO> findFriendRequestsByUserId(Long userId);
}

