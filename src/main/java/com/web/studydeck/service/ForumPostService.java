package com.web.studydeck.service;

import com.web.studydeck.model.entity.ForumPost;

import java.util.List;

import com.web.studydeck.model.service.ForumPostDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ForumPostService {
    Flux<ForumPostDTO> findAllForumPosts();
    Mono<ForumPostDTO> findForumPostById(Long id);
    Mono<ForumPostDTO> saveForumPost(ForumPostDTO forumPostDTO);
    Mono<Void> deleteForumPost(Long id);
}
