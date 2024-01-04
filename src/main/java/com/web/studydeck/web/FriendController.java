package com.web.studydeck.web;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Friend>> listFriends(@PathVariable Long userId) {
        // Logic to list all friends of a user
        List<Friend> friends = friendService.findFriendsByUserId(userId);
        return ResponseEntity.ok(friends);
    }

    @PostMapping("/request")
    public ResponseEntity<Friend> sendFriendRequest(@RequestBody Friend friend) {
        // Logic to send a friend request
        Friend newFriend = friendService.saveFriend(friend);
        return ResponseEntity.ok(newFriend);
    }

    @GetMapping("/requests/{userId}")
    public ResponseEntity<List<Friend>> viewFriendRequests(@PathVariable Long userId) {
        // Logic to view friend requests for a user
        List<Friend> friendRequests = friendService.findFriendRequestsByUserId(userId);
        return ResponseEntity.ok(friendRequests);
    }
}
