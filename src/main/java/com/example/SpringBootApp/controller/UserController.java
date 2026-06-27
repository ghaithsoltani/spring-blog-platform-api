package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.entity.UserEntity;
import com.example.SpringBootApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService us;

    @PostMapping("addUser")
    public UserEntity add(@RequestBody UserEntity user){
        return us.addUser(user);
    }

    @PutMapping("upDataUser/{idUser}")
    public String upData(@RequestBody UserEntity user ,@PathVariable int idUser){
        String message;
        us.upDataUser(user, idUser);
        message = "User updata";
        return message;
    }

    @PutMapping("upDataUserWithRequestParam")
    public String upDataWithRequestParam(@RequestBody UserEntity user ,@RequestParam("idU") int idUser){
        String message;
        us.upDataUser(user, idUser);
        message = "User updata";
        return message;
    }

    @GetMapping("getByEmail")
    public UserEntity getByIdEmail(@RequestParam("email") String email){
        return us.getByIdEmail(email);
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        String message = "";
        us.deleteById(id);
        message = "Delete user is seccesid";
        return message;
    }
    @GetMapping("listeAllUsers")
    public List<UserEntity> getAllUsers() {
        return us.getAllUsers();
    }

    @PostMapping("addAllUsers")
    public List<UserEntity> addAllUsers(@RequestBody List<UserEntity> userEntities) {
        return us.addAllUsers(userEntities);
    }

    @PostMapping("addUserIfNotExest")
    public String add2(@RequestBody UserEntity user){
        return us.add(user);
    }

    @PostMapping("addUserIfPWnotConfirled")
    public String addUserIfPWnotConfirled(@RequestBody UserEntity user){
        return us.addPw(user);
    }

    @PutMapping("updataUsers/{id}")
    public UserEntity updateUser(@PathVariable int id ,@RequestBody UserEntity user){
        return us.updateUsers(id, user);
    }
    @GetMapping("getByUserId/{id}")
    public UserEntity getByUserId(@PathVariable int id){
        return us.getUserById(id);
    }
    @GetMapping("getUsersWithReqetPersonaliser/{un}")
    public List<UserEntity> getUsersSerch(@PathVariable String un){
        return us.getSerch(un);
    }
    @PostMapping("userAddRole")
    public UserEntity userAddRole(@RequestBody UserEntity user){
        return us.userAddRole(user);
    }
}
