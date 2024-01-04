package com.web.studydeck.service;

import com.web.studydeck.model.entity.ForumPost;

import java.util.List;

public interface ForumPostService {
    List<ForumPost> findAllForumPosts();
    ForumPost findForumPostById(Long id);
    ForumPost saveForumPost(ForumPost forumPost);
    void deleteForumPost(Long id);
    // Other necessary methods
}
