package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile user;

    @ManyToOne
    private Skill skill;

    private String urgencyLevel;
    private boolean active = true;

    // fields used by SkillMatchingEngine
    private String skillName;
    private String skillCategory;
    private String requiredLevel;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getUser() {
        return user;
    }
    public void setUser(UserProfile user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }
    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    // ===== methods expected by SkillMatchingEngine =====

    public String getSkillName() {
        if (skill != null && skill.getName() != null) {
            return skill.getName();
        }
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillCategory() {
        if (skill != null && skill.getCategory() != null) {
            return skill.getCategory();
        }
        return skillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
