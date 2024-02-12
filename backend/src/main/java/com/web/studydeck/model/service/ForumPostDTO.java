package com.web.studydeck.model.service;

public class ForumPostDTO {
    private String content;
    private String username;

    public ForumPostDTO(String content, String username) {
        this.content = content;
        this.username = username;
    }

    public ForumPostDTO() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Constructors, Getters, and Setters
}
