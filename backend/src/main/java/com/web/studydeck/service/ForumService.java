package com.web.studydeck.service;

import com.web.studydeck.model.service.ForumDTO;
import com.web.studydeck.model.service.ForumPostDTO;

import java.util.List;

public interface ForumService {
    List<ForumDTO> findAllForums();
    ForumDTO findForumById(String name);
    ForumPostDTO saveComment(ForumPostDTO forumPostDTO, String threadName, Long userId);
    void deleteForum(Long id);
}
