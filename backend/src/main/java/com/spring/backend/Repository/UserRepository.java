package com.spring.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.backend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
