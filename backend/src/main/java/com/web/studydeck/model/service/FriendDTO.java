package com.web.studydeck.model.service;

import com.web.studydeck.model.enums.FriendStatus;

import java.time.LocalDateTime;

public class FriendDTO {
    private Long id;
    private Long userId;
    private Long friendId;
    private LocalDateTime createdAt;
    private FriendStatus status;

}
