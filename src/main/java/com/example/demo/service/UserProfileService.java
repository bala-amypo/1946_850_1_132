package com.example.demo.service;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired private UserProfileRepository repository;

    public UserProfile createUser(UserProfile user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(user);
    }

    public UserProfile getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("UserProfile not found"));
    }

    public void deactivateUser(Long id) {
        UserProfile user = getUserById(id);
        user.setActive(false);
        repository.save(user);
    }
}