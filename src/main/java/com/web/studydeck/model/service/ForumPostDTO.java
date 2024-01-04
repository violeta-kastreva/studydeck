package com.web.studydeck.model.service;

import java.time.LocalDateTime;

public class ForumPostDTO {
    private Long id;
    private Long forumId; // Assuming each post is associated with a forum
    private String content;
    private LocalDateTime createdAt;
    private Long userId; // Assuming each post is associated with a user

    // Constructors, Getters, and Setters
}
