package com.example.SpringBootApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data // Generatte all need from Variobels (Get ,Set ,...)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "fName")
    private String firstName;
    @Column(name = "lName")
    private String lastName;
    private String email;
    private String userName;
    @Transient
    private String confirmerPassword;
    private String password;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToMany
    @JoinTable(name = "userrole" ,joinColumns = @JoinColumn(name = "id") ,inverseJoinColumns = @JoinColumn(name = "idRole"))
    private Set<Role> role = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Set<Post> post = new HashSet<>();




}
