package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity addUser(UserEntity user);
    UserEntity upDataUser(UserEntity user, int idUser);
    UserEntity getByIdEmail(String email);
    void deleteById(int id);
    List<UserEntity> getAllUsers();
    List<UserEntity> addAllUsers(List<UserEntity> userEntities);
    String add(UserEntity user);
    String addPw(UserEntity user);

    UserEntity updateUsers(int id, UserEntity user);

    UserEntity getUserById(int id);

    List<UserEntity> getSerch(String un);

    UserEntity userAddRole(UserEntity user);
}
