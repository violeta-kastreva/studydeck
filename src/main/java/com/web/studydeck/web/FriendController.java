package com.web.studydeck.web;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.service.FriendDTO;
import com.web.studydeck.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/{userId}")
    public Flux<FriendDTO> listFriends(@PathVariable Long userId) {
        return friendService.findFriendsByUserId(userId);
    }

    @PostMapping("/request")
    public Mono<FriendDTO> sendFriendRequest(@RequestBody FriendDTO friendDTO) {
        return friendService.saveFriend(friendDTO);
    }

    @GetMapping("/requests/{userId}")
    public Flux<FriendDTO> viewFriendRequests(@PathVariable Long userId) {
        return friendService.findFriendRequestsByUserId(userId);
    }

    // Additional endpoints...
}
