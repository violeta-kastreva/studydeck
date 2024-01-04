package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.ForumPost;
import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.repository.ForumPostRepository;
import com.web.studydeck.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ForumPostServiceImpl implements ForumPostService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Flux<ForumPostDTO> findAllForumPosts() {
        return forumPostRepository.findAll()
                .map(post -> modelMapper.map(post, ForumPostDTO.class));
    }

    @Override
    public Mono<ForumPostDTO> findForumPostById(Long id) {
        return forumPostRepository.findById(id)
                .map(post -> modelMapper.map(post, ForumPostDTO.class));
    }

    @Override
    public Mono<ForumPostDTO> saveForumPost(ForumPostDTO forumPostDTO) {
        ForumPost forumPost = modelMapper.map(forumPostDTO, ForumPost.class);
        return forumPostRepository.save(forumPost)
                .map(savedPost -> modelMapper.map(savedPost, ForumPostDTO.class));
    }

    @Override
    public Mono<Void> deleteForumPost(Long id) {
        return forumPostRepository.deleteById(id);
    }
}

