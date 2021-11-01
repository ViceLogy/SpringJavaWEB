package com.example.javaspring.repositories;

import com.example.javaspring.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepo extends JpaRepository<MyUser, Long> {
    MyUser findByLogin(String login);
}
