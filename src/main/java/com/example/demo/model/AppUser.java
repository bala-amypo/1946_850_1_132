package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppUser {
    private String role = "MONITOR";  // Default for test case 31
    private LocalDateTime createdAt;
}
