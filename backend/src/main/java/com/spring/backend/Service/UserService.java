package com.spring.backend.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.backend.Repository.UserRepository;
import com.spring.backend.Entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create User
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve User
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update User
    public User updateUser(long id, User updateUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    // Update only Username
    public User updateUsername(long id, User updateUsername) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User username = optionalUser.get();
            username.setUsername(updateUsername.getUsername());
            return userRepository.save(username);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    // Update only Password
    public User updatePassword(long id, User updatePassword) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User password = optionalUser.get();
            password.setPassword(updatePassword.getPassword());
            return userRepository.save(password);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

    // Delete all User
    public void deleteAll() {
        userRepository.deleteAll();
    }

    // Delete by Id
    public void deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }

}
