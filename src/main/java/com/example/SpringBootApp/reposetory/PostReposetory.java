package com.example.SpringBootApp.reposetory;

import com.example.SpringBootApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostReposetory extends JpaRepository<Post,Integer> {


}
