package com.nc.postgresql_crud.service;

import com.nc.postgresql_crud.entity.Comment;
import com.nc.postgresql_crud.entity.User;
import com.nc.postgresql_crud.exception.UserNotFound;
import com.nc.postgresql_crud.model.CommentResponse;
import com.nc.postgresql_crud.model.UserInput;
import com.nc.postgresql_crud.repositry.CommentRepository;
import com.nc.postgresql_crud.repositry.UserRepository;
import com.nc.postgresql_crud.response.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @Transactional
    public String saveComment(UserInput data) {

        String msg = "comment added successfully";
        User user = userRepository.findByCommentTo(data.getCommentTo()).orElse(new User());
        if (user.getCommentTo() == null) {
            user.setCommentTo(data.getCommentTo());
            // save user object
            try {
                user = userRepository.save(user);
            } catch (Exception e) {
                msg = e.getMessage();
            }
        }
        Comment comment = new Comment();
        comment.setMessage(data.getMessage());
        comment.setCommentDate(new Date());
        comment.setPostedByUser(user);
        comment.setComment_From(data.getCommentFrom());
        // saved the comment object
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @Transactional
    public CommentResponse getComments(String commentTo) {
        User user = userRepository.findByCommentTo(commentTo).orElseThrow(() -> new UserNotFound());
        List<Comment> commentList = commentRepository.findAll().stream().filter(i -> i.getPostedByUser().getUser_id() == 2).collect(Collectors.toList());

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentTo(commentTo);
        commentResponse.setPayload(commentList.stream().map(i -> new com.nc.postgresql_crud.model.Comment(i.getComment_From(), i.getCommentDate(), i.getMessage())).collect(Collectors.toList()));
        return commentResponse;
    }


}

