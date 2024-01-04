package com.web.studydeck.service;

import com.web.studydeck.model.entity.Forum;

import java.util.List;

public interface ForumService {
    List<Forum> findAllForums();
    Forum findForumById(Long id);
    Forum saveForum(Forum forum);
    void deleteForum(Long id);
    // Other necessary methods
}
