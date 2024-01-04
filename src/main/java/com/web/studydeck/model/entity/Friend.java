package com.web.studydeck.model.entity;
import com.web.studydeck.model.enums.FriendStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User friend;

    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private FriendStatus status;

    // Getters and setters
}