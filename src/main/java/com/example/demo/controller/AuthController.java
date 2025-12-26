package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserProfileRepository userRepo;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          UserProfileRepository userRepo,
                          JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserProfile u = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("UserProfile not found"));

        String token = jwtUtil.generateToken(u.getEmail(), "USER", u.getId());
        LoginResponse res = new LoginResponse();
        res.setToken(token);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody LoginRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        UserProfile u = new UserProfile();
        u.setEmail(request.getEmail());
        u.setPassword(request.getPassword());
        u.setUsername(request.getEmail());
        userRepo.save(u);

        String token = jwtUtil.generateToken(u.getEmail(), "USER", u.getId());
        LoginResponse res = new LoginResponse();
        res.setToken(token);
        return ResponseEntity.ok(res);
    }
}
