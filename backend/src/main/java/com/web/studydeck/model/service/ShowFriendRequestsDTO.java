package com.web.studydeck.model.service;

public class ShowFriendRequestsDTO {
    String username;

    public ShowFriendRequestsDTO(String username) {
        this.username = username;
    }

    public ShowFriendRequestsDTO() {


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
