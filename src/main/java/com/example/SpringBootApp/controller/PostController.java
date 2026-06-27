package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.entity.Post;
import com.example.SpringBootApp.services.PostServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostServes ps;
    @PostMapping("/addNewPost")
    public Post addNewPost(@RequestBody Post post){
        post.setCrreentDate(LocalDate.now());
        return ps.addPost(post);
    }

    @PostMapping("createPost/{id}")
    public Post createPost(@PathVariable int id , @RequestBody Post post){
        return ps.createPost(id ,post);
    }

    @GetMapping("listPoste")
    public List<Post> postList(){
        return ps.postList();
    }
}
