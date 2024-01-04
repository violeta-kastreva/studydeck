package com.web.studydeck.service;

import com.web.studydeck.model.entity.Forum;

import java.util.List;

import com.web.studydeck.model.service.ForumDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ForumService {
    Flux<ForumDTO> findAllForums();
    Mono<ForumDTO> findForumById(Long id);
    Mono<ForumDTO> saveForum(ForumDTO forumDTO);
    Mono<Void> deleteForum(Long id);
}

