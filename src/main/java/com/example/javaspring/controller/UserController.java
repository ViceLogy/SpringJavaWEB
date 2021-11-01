package com.example.javaspring.controller;

import com.example.javaspring.dtoe.UserDTO;
import com.example.javaspring.entity.User;
import com.example.javaspring.service.userservice.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api(value = "user", description = "Rest API for user operation", tags = "user API")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all user")
    public ResponseEntity<List<User>> getAll(){
        List<com.example.javaspring.entity.User> userList = service.all();
        if (userList != null){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(auth);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Get one user")
    public ResponseEntity<User> one(@PathVariable @Valid @NotBlank Long id){
        return ResponseEntity.ok(service.one(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create user to DB")
    public ResponseEntity<User> save(@Valid @NotBlank @RequestBody com.example.javaspring.entity.User user){
        return ResponseEntity.ok(service.add(user));
    }

    @PutMapping
    @ApiOperation(value = "Update user")
    public ResponseEntity<User> update(@Valid @NotBlank @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.update(userDTO.getUser(), userDTO.getId()));
    }

    @DeleteMapping("/del/")
    @ApiOperation(value = "Delete user")
    public ResponseEntity<User> delete(@RequestParam("id") @Valid @NotBlank Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
