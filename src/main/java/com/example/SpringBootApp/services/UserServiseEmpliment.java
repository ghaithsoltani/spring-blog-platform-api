package com.example.SpringBootApp.services;

import com.example.SpringBootApp.entity.Role;
import com.example.SpringBootApp.entity.UserEntity;
import com.example.SpringBootApp.reposetory.RoleReposetory;
import com.example.SpringBootApp.reposetory.UserEntityReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiseEmpliment implements UserService{
    @Autowired
    UserEntityReposetory ur;
    @Autowired
    RoleReposetory rr;


    @Override
    public UserEntity addUser(UserEntity user) {
        return ur.save(user);
    }

    @Override
    public UserEntity upDataUser(UserEntity user, int idUser) {
        UserEntity getUserId = ur.findById(idUser).get();
        getUserId.setUserName(user.getUserName());
        getUserId.setPassword(user.getPassword());
        return ur.save(getUserId); // Retunr user after updatated
    }

    @Override
    public UserEntity getByIdEmail(String email) {
        UserEntity getUserEmail = ur.findByEmail(email);
        return getUserEmail;
    }

    @Override
    public void deleteById(int id) {
        ur.deleteById(id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return List.of();
    }

    @Override
    public List<UserEntity> addAllUsers(List<UserEntity> userEntities) {
        return (List<UserEntity>) ur.saveAll(userEntities);
    }

    @Override
    public String add(UserEntity user) {
        if(ur.existsByEmail(user.getEmail())){
            return "already Exest !!";
        }else{
            ur.save(user);
        }
        return "Seccesfully user not fond olredy";
    }

    public String addPw(UserEntity user){
        if (user.getPassword().equals(user.getConfirmerPassword())) {
            ur.save(user);
            return "seccsesfully";
        }else{
            return "not equlse";
        }

    }

    @Override
    public UserEntity updateUsers(int id, UserEntity user) {
        UserEntity getUserId = ur.findById(id).get();

        getUserId.setEmail(user.getEmail());
        getUserId.setFirstName(user.getFirstName());
        return ur.save(getUserId);
    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity getUserId = ur.findById(id).get();

        return getUserId;
    }

    @Override
    public List<UserEntity> getSerch(String un) {
        return ur.getSerch(un);
    }

    @Override
    public UserEntity userAddRole(UserEntity user) {
        Role role = rr.findById(1L).orElse(null);
        user.getRole().add(role);
        return ur.save(user);
    }


}
