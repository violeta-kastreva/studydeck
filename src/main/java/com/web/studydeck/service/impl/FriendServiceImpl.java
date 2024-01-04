package com.web.studydeck.service.impl;
import com.web.studydeck.model.entity.Friend;
import com.web.studydeck.model.enums.FriendStatus;
import com.web.studydeck.model.service.FriendDTO;
import com.web.studydeck.repository.FriendRepository;
import com.web.studydeck.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendRepository friendRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Flux<FriendDTO> findAllFriends() {
        return friendRepository.findAll()
                .map(friend -> modelMapper.map(friend, FriendDTO.class));
    }

    @Override
    public Mono<FriendDTO> findFriendById(Long id) {
        return friendRepository.findById(id)
                .map(friend -> modelMapper.map(friend, FriendDTO.class));
    }

    @Override
    public Mono<FriendDTO> saveFriend(FriendDTO friendDTO) {
        Friend friend = modelMapper.map(friendDTO, Friend.class);
        return friendRepository.save(friend)
                .map(savedFriend -> modelMapper.map(savedFriend, FriendDTO.class));
    }

    @Override
    public Mono<Void> deleteFriend(Long id) {
        return friendRepository.deleteById(id);
    }

    @Override
    public Flux<FriendDTO> findFriendsByUserId(Long userId) {
        return friendRepository.findAllByUserId(userId)
                .map(friend -> modelMapper.map(friend, FriendDTO.class));
    }

    @Override
    public Flux<FriendDTO> findFriendRequestsByUserId(Long userId) {
        return friendRepository.findByFriendIdAndStatus(userId, FriendStatus.REQUESTED)
                .map(friendRequest -> modelMapper.map(friendRequest, FriendDTO.class));
    }
}
