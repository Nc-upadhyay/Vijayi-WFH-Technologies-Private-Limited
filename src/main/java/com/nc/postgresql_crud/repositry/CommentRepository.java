package com.nc.postgresql_crud.repositry;

import com.nc.postgresql_crud.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
