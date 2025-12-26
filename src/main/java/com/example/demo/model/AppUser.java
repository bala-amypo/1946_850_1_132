package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppUser {
    private String role = "MONITOR";
    private LocalDateTime createdAt;
}