package com.spring.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.Repository.UserRepository;
import com.spring.backend.Entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updatedUser(long id, User userUpdate) {
        User user = userRepository.findById(id);
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

}
