package com.web.studydeck.web;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.enums.FriendStatus;
import com.web.studydeck.model.service.FriendPageDTO;
import com.web.studydeck.model.service.ShowFriendDTO;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;


@RestController
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private UserRepository userRepository;
    public FriendController(FriendService friendService, UserRepository userRepository) {
        this.friendService = friendService;
        this.userRepository = userRepository;
    }

    @GetMapping("/friends")
    public ResponseEntity<FriendPageDTO> listFriends(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElse(new User());
        FriendPageDTO friendPageDTO = new FriendPageDTO();
        friendPageDTO.setFriendsUsernames(new HashSet<>());
        friendPageDTO.setRequestsUsernames(new HashSet<>());

        user.getFriends().forEach(
                friend -> {
                    if(friend.getStatus().equals(FriendStatus.ACCEPTED)){
                        friendPageDTO.getFriendsUsernames().add((friend.getUser().getUsername()));
                    } else if (friend.getStatus().equals(FriendStatus.REQUESTED)){
                        friendPageDTO.getRequestsUsernames().add((friend.getUser().getUsername()));
                    }
                }
        );

        return ResponseEntity.ok(friendPageDTO);
    }


    @PostMapping("/friends/send/{username}")
    public ResponseEntity<ShowFriendDTO> sendFriendRequest(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("Friend not found"));
        Long userId = user.getId();
        ShowFriendDTO savedFriend = friendService.saveFriend(new ShowFriendDTO(username), userId);
        return ResponseEntity.ok(savedFriend);
    }

    @DeleteMapping("/friends/delete/{username}")
    public ResponseEntity<ShowFriendDTO> viewFriendRequests(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("Friend not found"));
        Long userId = user.getId();
        friendService.deleteFriend(username, userId);
        return ResponseEntity.ok(new ShowFriendDTO(username));
    }

    @PostMapping("/friends/accept/{username}")
    public ResponseEntity<ShowFriendDTO> acceptFriendRequest(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("Friend not found"));
        Long userId = user.getId();
        ShowFriendDTO savedFriend = friendService.acceptFriend(new ShowFriendDTO(username), userId);
        return ResponseEntity.ok(savedFriend);
    }
}
