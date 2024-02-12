package com.web.studydeck.service.impl;

import com.web.studydeck.model.entity.Forum;
import com.web.studydeck.model.entity.ForumPost;
import com.web.studydeck.model.service.ForumDTO;
import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.repository.ForumPostRepository;
import com.web.studydeck.repository.ForumRepository;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.ForumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements ForumService {

    private ForumRepository forumRepository;

    private ForumPostRepository forumPostRepository;

    private UserRepository userRepository;

    public ForumServiceImpl(ForumRepository forumRepository, ForumPostRepository forumPostRepository, UserRepository userRepository) {
        this.forumRepository = forumRepository;
        this.forumPostRepository = forumPostRepository;
        this.userRepository = userRepository;
    }

    private final ModelMapper modelMapper = new ModelMapper();
    Long id = 1L;
    @Override
    public List<ForumDTO> findAllForums() {
        return forumRepository.findAll().stream()
                .map(forum ->
                {
                    ForumDTO forumDTO = new ForumDTO();
                    forumDTO.setTitle(forum.getTitle());
                    forumDTO.setCommentsCount(forum.getPosts().size());
                    forumDTO.setId(id++);
                    forumDTO.setRowTitle("long description...");
                    forumDTO.setMessages(new HashSet<>());

                    for(ForumPost forumPost : forum.getPosts()){
                        ForumPostDTO forumPostDTO = new ForumPostDTO();
                        forumPostDTO.setUsername(forumPost.getUser().getUsername());
                        forumPostDTO.setContent(forumPost.getContent());

                        forumDTO.getMessages().add(forumPostDTO);
                    }
                    return forumDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ForumDTO findForumById(String name) {
        Forum forum = forumRepository.findByTitle(name)
                .orElseThrow(() -> new EntityNotFoundException("Forum not found with id " + id));
        ForumDTO forumDTO = modelMapper.map(forum, ForumDTO.class);
        forumDTO.setId(forum.getId());
        forumDTO.setCommentsCount(forum.getPosts().size());
        forumDTO.setUsername(forum.getUser().getUsername());
        forumDTO.setTitle(forum.getTitle());
        forumDTO.setMessages(new HashSet<>());
        for (ForumPost forumPost : forum.getPosts()){
            forumDTO.getMessages().add(new ForumPostDTO(forumPost.getContent(), forumPost.getUser().getUsername()));
        }
        return forumDTO;
    }

    @Override
    public ForumPostDTO saveComment(ForumPostDTO forumPostDTO, String threadName, Long userId) {
        ForumPost forumPost = new ForumPost();
        Forum forum = forumRepository.findByTitle(threadName).orElse(null);
        if(forum!=null){
            forumPost.setForum(forum);
            forumPost.setContent(forumPost.getContent());
            forumPost.setContent(forumPostDTO.getContent());
            forumPost.setUser(userRepository.findById(userId).orElse(null));
        }
        if(forum.getPosts() == null) forum.setPosts(new HashSet<>());
        forum.getPosts().add(forumPost);
        forumPostRepository.save(forumPost);

        return forumPostDTO;
    }

    @Override
    public void deleteForum(Long id) {
        forumRepository.deleteById(id);
    }
}

