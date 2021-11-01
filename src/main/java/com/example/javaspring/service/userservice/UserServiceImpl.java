package com.example.javaspring.service.userservice;

import com.example.javaspring.entity.User;
import com.example.javaspring.repositories.UserRepo;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class UserServiceImpl implements UserService{

    private final UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<User> all() {
        try {
            return repository.findAll();
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
    }

    @Override
    public User one(Long id) {
        try {
            if (id != null)
                return repository.getById(id);
            return null;
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
    }

    @Override
    public User add(User user) {
        try {
            if (repository.findForValidation(user.getName(), user.getLastName()) == null) {
                repository.save(user);
                return user;
            }
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public User update(User user, Long id) {
        try {
            if (!repository.getById(id).equals(user)){
                boolean update = repository.update(user.getName(), user.getLastName(), id);
                if (update) {
                    return user;
                }
            }
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public User delete(Long id) {
        try {
            if (id != null){
                User byId = repository.getById(id);
                repository.delete(byId);
                return byId;
            }
        }catch (Exception exception){
            log.severe(exception.getMessage());
            return null;
        }
        return null;
    }
}
