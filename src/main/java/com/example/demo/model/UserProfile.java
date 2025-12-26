package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String password;
    
    private boolean active = true;  // Default true for test case 26
    
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
