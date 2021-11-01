package com.example.javaspring.service.userservice;

import com.example.javaspring.entity.User;

import java.util.List;

public interface UserService {
    List<User> all();

    User one(Long id);

    User add(User user);

    User update(User user, Long id);

    User delete(Long id);
}
