package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.Post;
import com.example.SpringBootApp.entity.UserEntity;
import com.example.SpringBootApp.reposetory.PostReposetory;
import com.example.SpringBootApp.reposetory.UserEntityReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServesEmpliment implements PostServes {
    @Autowired
    PostReposetory pr;
    @Autowired
    UserEntityReposetory ur;


    @Override
    public Post addPost(Post post) {
        return pr.save(post);
    }



    @Override
    public Post createPost(int id, Post post) {
        Optional<UserEntity> user = ur.findById(id);
        if (user.isPresent()) {
            post.setUser((UserEntity) user.get());
            post.setCrreentDate(LocalDate.now());
            return pr.save(post);
        } else {
            throw new IllegalArgumentException("User Not Found");
        }
    }

    @Override
    public List<Post> postList() {
        return pr.findAll();
    }
}
