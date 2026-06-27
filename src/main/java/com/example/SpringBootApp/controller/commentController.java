package com.example.SpringBootApp.controller;


import com.example.SpringBootApp.entity.Comment;
import com.example.SpringBootApp.services.CommentServse;
import com.example.SpringBootApp.services.PostServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class commentController {
    @Autowired
    CommentServse cs;
    @Autowired
    PostServes ps;

    @PostMapping("/add/user/{userId}/post/{postId}")
    public Comment createComment(@PathVariable int userId , @PathVariable int postId , @RequestBody Comment comment){
        return cs.createComment(userId ,postId ,comment);
    }
}
