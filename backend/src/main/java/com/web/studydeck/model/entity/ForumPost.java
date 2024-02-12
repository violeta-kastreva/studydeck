package com.web.studydeck.model.entity;
import javax.persistence.*;


@Entity
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Forum forum;

    // Add this field and annotations to establish the many-to-one relationship
    @ManyToOne
    @JoinColumn(name = "user_id") // Adjust the column name as necessary
    private User user;

    // Getters and setters including the new user field

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
