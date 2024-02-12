package com.web.studydeck.model.service;

public class ShowFriendDTO {
    private String username;

    public ShowFriendDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
