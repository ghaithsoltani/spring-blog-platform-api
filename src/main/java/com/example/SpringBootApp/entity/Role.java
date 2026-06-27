package com.example.SpringBootApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Rolename roleName;
    @JsonIgnore
    @ManyToMany(mappedBy = "role")
    private Set<UserEntity> user = new HashSet<>();

}
