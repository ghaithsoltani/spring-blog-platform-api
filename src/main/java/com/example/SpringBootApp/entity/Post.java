package com.example.SpringBootApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Temporal;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String bady;


    private LocalDate crreentDate; // just works


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @JsonIgnore
    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    private Set<Comment> commentSet = new HashSet<>();

}
