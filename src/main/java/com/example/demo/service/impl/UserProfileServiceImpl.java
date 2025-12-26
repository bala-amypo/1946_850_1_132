package com.example.demo.service.impl;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    
    @Autowired
    private UserProfileRepository repository;
    
    @Override
    public UserProfile createUser(UserProfile user) {
        if (user.getEmail() != null && repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return repository.save(user);
    }
    
    @Override
    public UserProfile getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserProfile not found"));
    }
    
    @Override
    public void deactivateUser(Long id) {
        UserProfile user = getUserById(id);
        user.setActive(false);
        repository.save(user);
    }
}
