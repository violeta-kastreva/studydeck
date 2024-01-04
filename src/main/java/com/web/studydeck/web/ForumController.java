package com.web.studydeck.web;

import com.web.studydeck.model.entity.Forum;
import com.web.studydeck.model.service.ForumDTO;
import com.web.studydeck.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping
    public Flux<ForumDTO> listForums() {
        return forumService.findAllForums();
    }

    @GetMapping("/thread/{threadId}")
    public Mono<ResponseEntity<ForumDTO>> getForumThread(@PathVariable Long threadId) {
        return forumService.findForumById(threadId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<ForumDTO>> createForum(@RequestBody ForumDTO forumDTO) {
        return forumService.saveForum(forumDTO)
                .map(ResponseEntity::ok);
    }

    // Additional endpoints...
}
