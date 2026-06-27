package com.example.SpringBootApp.reposetory;

import com.example.SpringBootApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReposetory extends JpaRepository<Role,Long> {
}
