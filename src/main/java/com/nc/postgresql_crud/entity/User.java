package com.nc.postgresql_crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String commentTo;

    public User(long user_id, String comment_To) {
        this.user_id = user_id;
        this.commentTo = comment_To;
    }

    public User() {
    }

}
