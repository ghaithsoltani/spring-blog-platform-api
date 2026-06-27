package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.Comment;
import com.example.SpringBootApp.entity.Post;
import com.example.SpringBootApp.entity.UserEntity;
import com.example.SpringBootApp.reposetory.CommentRepository;
import com.example.SpringBootApp.reposetory.PostReposetory;
import com.example.SpringBootApp.reposetory.UserEntityReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CommentServesEmpliment implements CommentServse{
    @Autowired
    PostReposetory pr;
    @Autowired
    CommentRepository cr;
    @Autowired
    UserEntityReposetory ur;



    @Override
    public Comment createComment(int userId, int postId ,Comment comment) {
        Optional<UserEntity> user = ur.findById(userId);
        if(user.isPresent()){
            Optional <Post> post = pr.findById(postId);
            if(post.isPresent()){
                Post pGet =post.get();

                comment.setPost(pGet);
                comment.setUser(user.get());
                comment.setCrreentDate(LocalDate.now());
                return cr.save(comment);
            }else{
                throw new IllegalArgumentException("post not found");
            }
        }else{
            throw new IllegalArgumentException("user not found");
        }

    }
}
