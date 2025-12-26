package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MatchRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private UserProfile userA;
    @ManyToOne
    private UserProfile userB;
    
    @ManyToOne
    private Skill skillOfferedByA;
    @ManyToOne
    private Skill skillOfferedByB; // Assuming bidirectional match
    
    private String status = "PENDING";
}