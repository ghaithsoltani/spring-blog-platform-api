package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.Comment;

public interface CommentServse {
    Comment createComment(int userId, int postId ,Comment comment);
}
