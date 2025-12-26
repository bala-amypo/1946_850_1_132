package com.example.demo.service;

import com.example.demo.model.UserProfile;

public interface UserProfileService {
    UserProfile createUser(UserProfile userProfile);
    UserProfile getUserById(Long id);
    void deactivateUser(Long id);
}