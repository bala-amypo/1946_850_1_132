package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SkillOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private UserProfile user;
    
    @ManyToOne
    private Skill skill;
    
    private String experienceLevel;
    private boolean active = true;
}