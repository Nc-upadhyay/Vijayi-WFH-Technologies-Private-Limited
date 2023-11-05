package com.nc.postgresql_crud.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;

@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "comment_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;
    private String comment_From;
    @Column(name = "comment_date")
    private Date commentDate;
    @JoinColumn(name = "posted_by_user_id")
    @ManyToOne
    private User postedByUser;

    public Comment(long id, String message, Date commentDate, User postedByUser) {
        this.id = id;
        this.message = message;
        this.commentDate = commentDate;
        this.postedByUser = postedByUser;
    }
}
