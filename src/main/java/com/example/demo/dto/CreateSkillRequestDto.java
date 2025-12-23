package com.example.demo.dto;

import com.example.demo.dto.CreateSkillRequestDto;

public class CreateSkillRequestDto {
    private Long userId;
    private Long skillCategoryId;
    private String skillName;
    private String requiredLevel;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSkillCategoryId() {
        return skillCategoryId;
    }
    public void setSkillCategoryId(Long skillCategoryId) {
        this.skillCategoryId = skillCategoryId;
    }

    public String getSkillName() {
        return skillName;
    }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getRequiredLevel() {
        return requiredLevel;
    }
    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
