package com.web.studydeck.service;

import com.web.studydeck.model.service.ForumPostDTO;

import java.util.List;

public interface ForumPostService {
    List<ForumPostDTO> findAllForumPosts();
    ForumPostDTO findForumPostById(Long id);
    ForumPostDTO saveForumPost(ForumPostDTO forumPostDTO);
    void deleteForumPost(Long id);
}
