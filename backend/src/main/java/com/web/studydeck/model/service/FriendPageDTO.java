package com.web.studydeck.model.service;

import java.util.Set;

public class FriendPageDTO {
    Set<String> friendsUsernames;
    Set<String> requestsUsernames;


    public Set<String> getFriendsUsernames() {
        return friendsUsernames;
    }

    public void setFriendsUsernames(Set<String> friendsUsernames) {
        this.friendsUsernames = friendsUsernames;
    }

    public Set<String> getRequestsUsernames() {
        return requestsUsernames;
    }

    public void setRequestsUsernames(Set<String> requestsUsernames) {
        this.requestsUsernames = requestsUsernames;
    }
}
