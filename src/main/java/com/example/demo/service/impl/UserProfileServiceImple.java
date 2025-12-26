package com.example.demo.service.impl;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Override
    public UserProfile createUser(UserProfile userProfile) {
        return userProfile;
    }

    @Override
    public UserProfile getUserById(Long id) {
        UserProfile user = new UserProfile();
        user.setId(id);
        return user;
    }

    @Override
    public void deactivateUser(Long id) {
        // Mock implementation
    }
}