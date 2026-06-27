package com.example.SpringBootApp.reposetory;

import com.example.SpringBootApp.entity.UserEntity;
import com.example.SpringBootApp.services.UserService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityReposetory extends CrudRepository<UserEntity ,Integer> {

    UserEntity findByEmail(String email);


    void deleteById(Integer integer);

    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM user_entity u WHERE u.email := mail", nativeQuery = true)
    UserEntity selectByEmail(@Param("mail") String mail);

    @Query(value = "SELECT * FROM user_entity u WHERE u.user_name like :ch%" ,nativeQuery = true)
    List<UserEntity> getSerch(@Param("ch") String un);


    //Optional<UserService> findById(Long id);
    Optional<UserEntity> findById(Integer id);
}
