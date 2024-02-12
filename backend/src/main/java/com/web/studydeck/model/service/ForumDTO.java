package com.web.studydeck.model.service;

import java.util.Set;

public class ForumDTO {
    String title;

    String rowTitle;
    String username = "Admin";
    Integer commentsCount;
    Long id;
    Set<ForumPostDTO> messages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<ForumPostDTO> getMessages() {
        return messages;
    }

    public void setMessages(Set<ForumPostDTO> messages) {
        this.messages = messages;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRowTitle() {
        return rowTitle;
    }

    public void setRowTitle(String rowTitle) {
        this.rowTitle = rowTitle;
    }
}
