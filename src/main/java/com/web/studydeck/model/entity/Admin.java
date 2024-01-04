package com.web.studydeck.model.entity;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    // Specific fields and methods for admin

    // Getters and Setters
}
