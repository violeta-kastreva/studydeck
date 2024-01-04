package com.web.studydeck.service;

import com.web.studydeck.model.entity.Friend;

import java.util.List;

import com.web.studydeck.model.service.FriendDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FriendService {
    Flux<FriendDTO> findAllFriends();
    Mono<FriendDTO> findFriendById(Long id);
    Mono<FriendDTO> saveFriend(FriendDTO friendDTO);
    Mono<Void> deleteFriend(Long id);
    Flux<FriendDTO> findFriendsByUserId(Long userId);
    Flux<FriendDTO> findFriendRequestsByUserId(Long userId);
}

