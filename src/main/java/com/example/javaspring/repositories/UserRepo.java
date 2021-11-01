package com.example.javaspring.repositories;

import com.example.javaspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query( value = "SELECT * FROM users WHERE name = :name and last_name = :lastName", nativeQuery = true)
    User findForValidation(@Param("name")String name, @Param("lastName")String lastName);

    @Query(value = "UPDATE users SET name = :name, last_name = :lastName WHERE id = :id", nativeQuery = true)
    boolean update(@Param("name")String name, @Param("lastName")String lastName, @Param("id") Long id);
}
