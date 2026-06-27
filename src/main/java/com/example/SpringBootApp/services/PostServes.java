package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.Post;

import java.util.List;

public interface PostServes {


    Post addPost(Post post);

    Post createPost(int id, Post post);

    List<Post> postList();
}
