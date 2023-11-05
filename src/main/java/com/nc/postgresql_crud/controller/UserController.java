package com.nc.postgresql_crud.controller;

import com.nc.postgresql_crud.model.CommentResponse;
import com.nc.postgresql_crud.model.UserInput;
import com.nc.postgresql_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-comment")
    public ResponseEntity<String> saveUser(@RequestBody UserInput user) {
        return ResponseEntity.ok(userService.saveComment(user));
    }

    @GetMapping("/get-comment/")
    public CommentResponse getAllList(@RequestParam("com") String comment_to) {
        return userService.getComments(comment_to);
    }
}
