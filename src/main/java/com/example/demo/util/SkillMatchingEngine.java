package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        double score = 0.0;
        
        if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) score += 40;
        if (offer.getSkillCategory().getId().equals(request.getSkillCategory().getId())) score += 30;
        if (offer.getExperienceLevel().equals(request.getRequiredLevel())) score += 20;
        else if (isLevelSufficient(offer.getExperienceLevel(), request.getRequiredLevel())) score += 10;
        
        if (offer.getUser().getRating() >= 4.0) score += 10;
        else if (offer.getUser().getRating() >= 3.0) score += 5;
        
        return Math.min(score, 100.0);
    }
    
    private boolean isLevelSufficient(String offerLevel, String requiredLevel) {
        return offerLevel.equals("EXPERT") || 
               (offerLevel.equals("INTERMEDIATE") && !requiredLevel.equals("EXPERT"));
    }
}
