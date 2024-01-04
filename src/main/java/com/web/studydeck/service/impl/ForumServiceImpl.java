package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Forum;
import com.web.studydeck.model.service.ForumDTO;
import com.web.studydeck.repository.ForumRepository;
import com.web.studydeck.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumRepository forumRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Flux<ForumDTO> findAllForums() {
        return forumRepository.findAll()
                .map(forum -> modelMapper.map(forum, ForumDTO.class));
    }

    @Override
    public Mono<ForumDTO> findForumById(Long id) {
        return forumRepository.findById(id)
                .map(forum -> modelMapper.map(forum, ForumDTO.class));
    }

    @Override
    public Mono<ForumDTO> saveForum(ForumDTO forumDTO) {
        Forum forum = modelMapper.map(forumDTO, Forum.class);
        return forumRepository.save(forum)
                .map(savedForum -> modelMapper.map(savedForum, ForumDTO.class));
    }

    @Override
    public Mono<Void> deleteForum(Long id) {
        return forumRepository.deleteById(id);
    }
}
