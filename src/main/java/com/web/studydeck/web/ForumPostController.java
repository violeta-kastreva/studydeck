package com.web.studydeck.web;

import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/forum/posts")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @GetMapping
    public Flux<ForumPostDTO> listForumPosts() {
        return forumPostService.findAllForumPosts();
    }

    @GetMapping("/{postId}")
    public Mono<ResponseEntity<ForumPostDTO>> getForumPost(@PathVariable Long postId) {
        return forumPostService.findForumPostById(postId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<ForumPostDTO>> createForumPost(@RequestBody ForumPostDTO forumPostDTO) {
        return forumPostService.saveForumPost(forumPostDTO)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{postId}")
    public Mono<ResponseEntity<Void>> deleteForumPost(@PathVariable Long postId) {
        return forumPostService.deleteForumPost(postId)
                .thenReturn(ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
