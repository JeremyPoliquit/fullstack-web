package com.spring.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.Service.UserService;
import com.spring.backend.Entity.User;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create-user")
    public  User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update-user{id}")
    public ResponseEntity<User> updatedUser(@PathVariable Long id, @RequestBody User userUpdate) {
        User user = userService.updatedUser(id, userUpdate);
        return ResponseEntity.ok(user);
    }
}
