package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public ResponseEntity<UserProfile> create(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(userProfileService.createUser(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> get(@PathVariable Long id) {
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        userProfileService.deactivateUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<UserProfile>> listAll() {
        return ResponseEntity.ok(userProfileService.getUsersIterable());
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<UserProfile> updateRating(@PathVariable Long id,
                                                    @RequestParam("value") double rating) {
        UserProfile user = userProfileService.getUserById(id);
        user.setRating(rating);
        return ResponseEntity.ok(userProfileService.createUser(user));
    }
}
