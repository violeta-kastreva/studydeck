package com.web.studydeck.web;

import com.web.studydeck.model.service.ForumPostDTO;
import com.web.studydeck.service.ForumPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forum/posts")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @GetMapping
    public ResponseEntity<List<ForumPostDTO>> listForumPosts() {
        List<ForumPostDTO> posts = forumPostService.findAllForumPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ForumPostDTO> getForumPost(@PathVariable Long postId) {
        Optional<ForumPostDTO> post = Optional.ofNullable(forumPostService.findForumPostById(postId));
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{create}")
    public ResponseEntity<ForumPostDTO> createForumPost(@RequestBody ForumPostDTO forumPostDTO) {
        ForumPostDTO createdPost = forumPostService.saveForumPost(forumPostDTO);
        return ResponseEntity.ok(createdPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteForumPost(@PathVariable Long postId) {
        forumPostService.deleteForumPost(postId);
        return ResponseEntity.ok().build();
    }
}
