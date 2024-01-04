package com.web.studydeck.web;

import com.web.studydeck.model.entity.Forum;
import com.web.studydeck.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping
    public ResponseEntity<List<Forum>> listForums() {
        // Logic to list all forums
        List<Forum> forums = forumService.findAllForums();
        return ResponseEntity.ok(forums);
    }

    @GetMapping("/thread/{threadId}")
    public ResponseEntity<Forum> getForumThread(@PathVariable Long threadId) {
        // Logic to get a specific forum thread
        Forum forum = forumService.findForumById(threadId);
        return ResponseEntity.ok(forum);
    }

    @PostMapping("/create")
    public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
        // Logic to create a new forum thread
        Forum newForum = forumService.saveForum(forum);
        return ResponseEntity.ok(newForum);
    }
}
