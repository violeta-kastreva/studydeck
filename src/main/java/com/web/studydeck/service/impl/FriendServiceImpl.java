package com.web.studydeck.service.impl;
import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.enums.FriendStatus;
import com.web.studydeck.repository.FriendRepository;
import com.web.studydeck.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public List<Friend> findAllFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friend findFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    @Override
    public Friend saveFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }

    @Override
    public List<Friend> findFriendsByUserId(Long userId) {
        return friendRepository.findAllByUserId(userId);
    }

    @Override
    public List<Friend> findFriendRequestsByUserId(Long userId) {
        // Assuming "requested" is the status for pending friend requests
        return friendRepository.findByFriendIdAndStatus(userId, FriendStatus.REQUESTED);
    }

    // Additional business logic and methods
}
