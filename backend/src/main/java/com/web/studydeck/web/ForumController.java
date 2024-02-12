package com.web.studydeck.web;

import com.web.studydeck.model.entity.User;
import com.web.studydeck.model.service.AllForumsDTO;
import com.web.studydeck.model.service.ForumDTO;
import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.repository.UserRepository;
import com.web.studydeck.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @Autowired
    private UserRepository userRepository;

    public ForumController(ForumService forumService, UserRepository userRepository) {
        this.forumService = forumService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<AllForumsDTO> listForums() {
        List<ForumDTO> forums = forumService.findAllForums();
        AllForumsDTO allForums = new AllForumsDTO();
        allForums.getStatistics().setMessages(allForums.getThreads().size());
        allForums.getStatistics().setMembers(17);
        allForums.getStatistics().setThreads(5);
        allForums.setThreads(new ArrayList<>());
        allForums.setThreads(forums);
        return ResponseEntity.ok(allForums);
    }

    @GetMapping("/{threadName}")
    public ResponseEntity<Set<ForumPostDTO>> getForumThread(@PathVariable String threadName) {
        Optional<ForumDTO> forumDTO = Optional.ofNullable(forumService.findForumById(threadName));
        if (forumDTO.isPresent()) {
            return ResponseEntity.ok(forumDTO.get().getMessages()); // Successfully found
        } else {
            return ResponseEntity.notFound().build(); // Not found response
        }
    }

    @PostMapping("/{threadName}/comment")
    public ResponseEntity<ForumPostDTO> createForum(@PathVariable String threadName, @RequestBody ForumPostDTO forumPostDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Forum not found"));
        Long userId = user.getId();
        ForumPostDTO createdForumPost = forumService.saveComment(forumPostDTO, threadName, userId);
        return ResponseEntity.ok(createdForumPost); // Return the saved forum DTO
    }
}
