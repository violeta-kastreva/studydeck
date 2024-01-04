package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Forum;
import com.web.studydeck.repository.ForumRepository;
import com.web.studydeck.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumRepository forumRepository;

    @Override
    public List<Forum> findAllForums() {
        return forumRepository.findAll();
    }

    @Override
    public Forum findForumById(Long id) {
        return forumRepository.findById(id).orElse(null);
    }

    @Override
    public Forum saveForum(Forum forum) {
        return forumRepository.save(forum);
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }

    // Additional business logic and methods
}
