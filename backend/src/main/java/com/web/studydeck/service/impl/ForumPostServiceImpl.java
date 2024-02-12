package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.ForumPost;
import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.repository.ForumPostRepository;
import com.web.studydeck.service.ForumPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumPostServiceImpl implements ForumPostService {


    private ForumPostRepository forumPostRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ForumPostDTO> findAllForumPosts() {
        return forumPostRepository.findAll().stream()
                .map(post -> modelMapper.map(post, ForumPostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ForumPostDTO findForumPostById(Long id) {
        ForumPost post = forumPostRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ForumPost not found with id " + id));
        return modelMapper.map(post, ForumPostDTO.class);
    }

    @Override
    public ForumPostDTO saveForumPost(ForumPostDTO forumPostDTO) {

        ForumPost post = modelMapper.map(forumPostDTO, ForumPost.class);
        ForumPost savedPost = forumPostRepository.save(post);
        return modelMapper.map(savedPost, ForumPostDTO.class);
    }

    @Override
    public void deleteForumPost(Long id) {
        forumPostRepository.deleteById(id);
    }
}
