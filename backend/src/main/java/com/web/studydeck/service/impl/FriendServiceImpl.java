package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.enums.FriendStatus;
import com.web.studydeck.model.service.FriendDTO;
import com.web.studydeck.model.service.ShowFriendDTO;
import com.web.studydeck.repository.FriendRepository;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.FriendService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendServiceImpl implements FriendService {

    private FriendRepository friendRepository;

    private UserRepository userRepository;

    public FriendServiceImpl(FriendRepository friendRepository, UserRepository userRepository) {
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<FriendDTO> findAllFriends() {
        return friendRepository.findAll().stream()
                .map(friend -> modelMapper.map(friend, FriendDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FriendDTO findFriendById(Long id) {
        Friend friend = friendRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Friend not found with id " + id));
        return modelMapper.map(friend, FriendDTO.class);
    }

    @Override
    public ShowFriendDTO saveFriend(ShowFriendDTO friendDTO, Long userId) {
        User friend = userRepository.findByUsername(friendDTO.getUsername()).orElse(null);
        User sender = userRepository.findById(userId).orElse(null);
        Friend fr = new Friend(sender, friend, FriendStatus.REQUESTED);
        friendRepository.save(fr);
        if(friend.getFriends() == null) friend.setFriends(new HashSet<>());
        friend.getFriends().add(fr);

        return friendDTO;
    }

    @Override
    public void deleteFriend(String username, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        User friend = userRepository.findByUsername(username).orElse(null);
        if (user != null && friend != null) {
            user.getFriends().removeIf(friendship -> friendship.getFriend().getUsername().equals(username));
            friend.getFriends().removeIf(friendship -> friendship.getFriend().getUsername().equals(user.getUsername()));

            userRepository.save(user);
            userRepository.save(friend);
        }
    }

    @Override
    public List<FriendDTO> findFriendsByUserId(Long userId) {
        return friendRepository.findAllByUserId(userId).stream()
                .map(friend -> modelMapper.map(friend, FriendDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<FriendDTO> findFriendRequestsByUserId(Long userId) {
        return friendRepository.findByFriendIdAndStatus(userId, FriendStatus.REQUESTED).stream()
                .map(friendRequest -> modelMapper.map(friendRequest, FriendDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShowFriendDTO acceptFriend(ShowFriendDTO friendDTO, Long userId) {
        // Assume the friendDTO contains the username of the friend who sent the friend request
        // and userId is the ID of the user accepting the friend request

        // Find the friend request sent to the accepting user
        User acceptor = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        User requester = userRepository.findByUsername(friendDTO.getUsername()).orElseThrow(() -> new RuntimeException("Friend not found"));

        // Assuming FriendRepository has a method to find a Friend entity by the requester and acceptor
        // Also assuming Friend class has a setStatus method
        Friend friendRequest = friendRepository.findFirstByUserAndFriend(acceptor, requester)
                .orElseThrow(() -> new RuntimeException("Friend request not found"));


        friendRequest.setStatus(FriendStatus.ACCEPTED);
        friendRepository.saveAndFlush(friendRequest);

        // Ensure both users have initialized friends sets
        if (acceptor.getFriends() == null) acceptor.setFriends(new HashSet<>());
        if (requester.getFriends() == null) requester.setFriends(new HashSet<>());

        acceptor.getFriends().add(friendRequest);
        requester.getFriends().add(friendRequest);

        userRepository.save(acceptor);
        userRepository.save(requester);

        return friendDTO;
    }

}
