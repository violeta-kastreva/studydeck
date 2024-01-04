package com.web.studydeck.model.entity;
import jakarta.persistence.*;

@Entity
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Forum thread;

    // Getters and Setters
}