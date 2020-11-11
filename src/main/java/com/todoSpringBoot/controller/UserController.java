package com.todoSpringBoot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todoSpringBoot.model.User;
import com.todoSpringBoot.dto.UpdateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.todoSpringBoot.service.AuthService;
import com.todoSpringBoot.service.UserService;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    
    private final AuthService authService;
    private final UserService userService;
    
    @GetMapping
    public User getCurrentUser(){
        return authService.getCurrentUser();
    }
    
    @PutMapping
    public boolean updateUser(@RequestBody UpdateUser user){
        return userService.updateUser(user);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteProfile(){
        userService.deleteUser();
        return ResponseEntity.status(HttpStatus.OK).body("User profile deleted successfully");
    }
    
}
